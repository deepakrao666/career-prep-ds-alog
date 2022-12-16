package com.deepak.leetCode.binarySearch;

import java.util.Arrays;

public class BinarySearchBasics {

    public int doSomething(int[] nums, int k) {

        int lo = 0;
        int hi = Arrays.stream(nums).max().getAsInt();

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (isCondition(nums, k, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    private boolean isCondition(int[] nums, int k, int mid) {
        // do something

        return false;
    }
}
