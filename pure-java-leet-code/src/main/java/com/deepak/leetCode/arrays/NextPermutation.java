package com.deepak.leetCode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NextPermutation {

    public static void main(String[] args) {

        int[] ip = new int[]{3, 2, 1};

        nextPermutation(ip);

        System.out.println(Arrays.toString(ip));
    }

    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;


        final int[] ints = Arrays.copyOfRange(nums, 0, 4);
    }
}
