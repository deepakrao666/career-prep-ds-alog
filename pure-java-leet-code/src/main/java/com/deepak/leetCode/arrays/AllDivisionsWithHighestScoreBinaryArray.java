package com.deepak.leetCode.arrays;

import java.util.*;

public class AllDivisionsWithHighestScoreBinaryArray {

    public static void main(String[] args) {
        System.out.println(maxScoreIndices(new int[]{0, 0, 1, 0}));
    }

    public static List<Integer> maxScoreIndices(int[] nums) {
        int oneCount = 0;

        for (int num : nums) {
            if (num == 1) {
                oneCount++;
            }
        }

        int maxDivisor = oneCount;
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int runningCount = oneCount; //1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                runningCount++;
            } else if (nums[i] == 1) {
                runningCount--;
            }
            if (runningCount >= maxDivisor) {
                if (runningCount != maxDivisor) {
                    result.clear();
                    maxDivisor = runningCount;
                }
                result.add(i + 1);
            }

        }

        return result;
    }
}
