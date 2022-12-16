package com.deepak.leetCode.arrays;

import java.util.Arrays;

public class RandomPickWithWeight {
    // todo revise FB

    private int[] currSum;
    private int totalSum;

    public RandomPickWithWeight(int[] w) {
        this.currSum = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.currSum[i] = prefixSum;
        }
        this.totalSum = prefixSum;

        System.out.println(Arrays.toString(currSum));
    }

    public int pickIndex() {
        final double random = Math.random();
        double target = this.totalSum * random;
        System.out.println(target + " " + random);
        // run a binary search to find the target zone
        int low = 0, high = this.currSum.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.currSum[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
