package com.deepak.leetCode.arrays;

import java.util.Arrays;

public class MergeArray {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 1, 2, 3, 4, 1};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i = 0; i < m; i++){
            nums1[m+1] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

        }
    }


}
