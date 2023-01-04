package com.deepak.leetCode.arrays;

import java.util.*;

public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {

                int lo = j + 1;
                int hi = n - 1;

                while (lo < hi) {
                    long sum = (long) (nums[i] + nums[j]) + (long) (nums[lo] + nums[hi]);
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                    } else if (sum < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}
