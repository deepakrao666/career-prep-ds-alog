package com.deepak.leetCode.slidingWindow;

public class MaximumConsecutiveOnes2 {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0;
        int noOfZeros = 0;
        int res = 0;

        // while window is inbounds
        while (j < nums.length) {

            // add right most element to window
            if(nums[j] == 0){
                noOfZeros++;
            }
            // if window is invalid
            // contract window
            while (noOfZeros == 2){
                if(nums[i] == 0){
                    noOfZeros--;
                }
                i++;
            }
            // update ans
            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}
