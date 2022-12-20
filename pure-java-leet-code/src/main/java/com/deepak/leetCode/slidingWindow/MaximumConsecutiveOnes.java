package com.deepak.leetCode.slidingWindow;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0;
        int res = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                res = Math.max(res, j - i);
                i = j + 1;
            }

            j++;
        }
        res = Math.max(res, j - i);
        return res;
    }

    public static int findMaxConsecutiveOnesWithoutWindow(int[] nums) {

        int j = 0;
        int res = 0;
        int count = 0;
        while (j < nums.length) {
            if (nums[j] == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
            j++;
        }
        return res;
    }
}
