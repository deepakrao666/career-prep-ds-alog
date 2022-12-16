package com.deepak.leetCode.binarySearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {

        int max = 0;
        int sum = 0;

        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }

        int lo = 0;
        int high = sum;
        int ans = Integer.MAX_VALUE;

        while (lo <= high) {
            int mid = lo + (high - lo) / 2;
            if (condition(mid, nums, k)) {
                lo = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean condition(int mid, int[] arr, int m) {
        int sp = 1;
        int val = 0;

        for (int j : arr) {
            val += j;

            if (val > mid) {
                sp++;
                val = j;

                if (sp > m)
                    return true;
            }
        }

        return false;
    }

}
