package com.deepak.leetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices2Subsequence {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long ans = 0;

        Map<Integer, Integer>[] count = new Map[n];

        for (int i = 0; i < n; i++) {

            count[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {

                long delta = nums[i] - nums[j];

                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }

                int diff = (int) delta;
                int sum = count[j].getOrDefault(diff, 0);
                int origin = count[i].getOrDefault(diff, 0);

                count[i].put(diff, origin + sum + 1);

                ans += sum;
            }

        }

        return (int) ans;
    }
}
