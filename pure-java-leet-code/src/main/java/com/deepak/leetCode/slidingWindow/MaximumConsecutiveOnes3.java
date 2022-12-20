package com.deepak.leetCode.slidingWindow;

import java.util.Arrays;

public class MaximumConsecutiveOnes3 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;

        while (j < n) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[j] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                k += 1 - nums[i];
                i++;
            }
            j++;
        }

        return j - i;
    }
}
