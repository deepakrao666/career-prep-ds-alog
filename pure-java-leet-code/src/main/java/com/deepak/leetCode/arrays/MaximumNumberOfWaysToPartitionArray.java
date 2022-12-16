package com.deepak.leetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfWaysToPartitionArray {
    //time - O(n), space - O(n)
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        //contribution of prefixes without changing
        Map<Integer, Integer> count = new HashMap<>();
        count.put(prefixSum[0], 1);

        for (int i = 1; i < n - 1; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i];
            count.put(prefixSum[i], count.getOrDefault(prefixSum[i], 0) + 1);
        }
        //last step doesn't add into 'count' map, because we're trying to find at least two parts.
        prefixSum[n - 1] += prefixSum[n - 2] + nums[n - 1];

        int sum = prefixSum[n - 1];
        int max = 0;

        //max without changing
        if (sum % 2 == 0)
            max = count.getOrDefault(sum / 2, 0);

        //contribution of prefixes before current step
        Map<Integer, Integer> countPrev = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = k - nums[i];
            int changedSum = sum + diff;

            if (changedSum % 2 == 0) {
                Integer countVal = count.getOrDefault(changedSum / 2 - diff, 0);
                Integer countPrevVal = countPrev.getOrDefault(changedSum / 2, 0);

                max = Math.max(max, countVal + countPrevVal);
            }

            count.put(prefixSum[i], count.getOrDefault(prefixSum[i], 0) - 1);
            countPrev.put(prefixSum[i], countPrev.getOrDefault(prefixSum[i], 0) + 1);
        }
        return max;
    }
}
