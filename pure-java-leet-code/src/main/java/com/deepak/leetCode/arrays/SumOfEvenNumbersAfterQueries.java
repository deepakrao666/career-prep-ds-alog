package com.deepak.leetCode.arrays;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1, 2, 3, 4},
                new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}
        )));

    }

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        if (queries.length == 0)
            return nums;

        int currentSum = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                currentSum += num;
        }

        System.out.println(currentSum);

        int[] res = new int[queries.length];

        int i = 0;
        for (int[] row : queries) {

            int val = row[0];
            int index = row[1];

            if(nums[index] % 2 == 0){
                currentSum -= nums[index];
            }
            nums[index] += val;

            if(nums[index] % 2 == 0){
                currentSum += nums[index];
            }

           res[i++] = currentSum;
        }


        return res;
    }


}
