package com.deepak.leetCode.binarySearch;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        //Minimum sum of the subarray
        int low = IntStream.of(nums).max().getAsInt();
        //Maximum sum of the subarray
        int high = Arrays.stream(nums).sum();

        //To keep track of our answer.
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            //If subarray sum is valid i.e., it can be used to divide array into K subarrays.
            if (isValid(mid, nums, k)) {
                //We didn't find a subarray large enough to split array into K parts.
                low = mid + 1;
            } else {
                min = Math.min(min, mid);
                //Find a smaller subarray
                high = mid - 1;
            }
        }
        return min; //return answer
    }

    private boolean isValid(int mid, int[] nums, int k) {
        //No of subarrays that'll be generated for current sum
        int count = 0;
        int low = 0;
        while (low < nums.length) {
            int sum = 0;

            while (low < nums.length && sum + nums[low] <= mid){
                sum += nums[low++];
            }
            //Increment in no. of subarrays when one subarray is completed.
            count++;
        }
        //If no. of subarrays are in the range of K return true;
        return count > k;
    }

}
