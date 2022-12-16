package com.deepak.leetCode.binarySearch;

public class MaximumTotalSweetnessOrDivideChocolate {

    public static void main(String[] args) {
        System.out.println(maximizeSweetness(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
    }

    public static int maximizeSweetness(int[] nums, int k) {
        k += 1;

        int lo = Integer.MAX_VALUE;

        int sum = 0;
        int length = nums.length;

        for (int n : nums) {
            lo = Math.min(lo, n);
            sum += n;
        }

        int high = sum / k + Integer.signum(sum % length) + 1;

        while (lo < high) {

            int mid = lo + (high - lo) / 2;

            if (condition(mid, nums, k)) {
                lo = mid + 1;
            } else {
                high = mid;
            }

        }

        return lo - 1;

    }

    private static boolean condition(int guess, int[] nums, int nofPeople) {
        int peopleWithChocolate = 0;
        int currSweetness = 0;

        for (int n : nums) {
            currSweetness += n;

            if (currSweetness >= guess) {
                currSweetness = 0;
                peopleWithChocolate++;
            }
        }

        return peopleWithChocolate >= nofPeople;
    }
}
