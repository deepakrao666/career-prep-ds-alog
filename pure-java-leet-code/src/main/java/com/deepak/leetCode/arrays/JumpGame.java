package com.deepak.leetCode.arrays;


import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2, 2, 0, 3, 0, 0}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {

        System.out.println(Arrays.toString(nums));
        int n = nums.length;

        boolean[] isJumpPossible = new boolean[n];
        isJumpPossible[n-1] = true;
        for(int i = 0; i < n; i++){

            int jumpLength = nums[i] - 1;

            int counter = 0;
            while (counter <= jumpLength && i+counter < n-1){
                isJumpPossible[i + counter] = true;
                counter++;
            }
            System.out.println(Arrays.toString(isJumpPossible));

            if(!isJumpPossible[i]) {
                return false;
            }
        }

        return true;
    }

}
