package com.deepak.leetCode.dp;


public class SparseVector {
    int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;

         int[] incoming = vec.nums;

        for(int i = 0; i < incoming.length; i++){
            res += this.nums[i] * incoming[i];
        }


        return res;
    }

}
