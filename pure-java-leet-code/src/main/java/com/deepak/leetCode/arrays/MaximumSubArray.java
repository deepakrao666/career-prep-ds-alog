package com.deepak.leetCode.arrays;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int currentMax = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum - currentMax);
            currentMax = Math.min(currentMax, sum);
        }

        return max;
    }

}
