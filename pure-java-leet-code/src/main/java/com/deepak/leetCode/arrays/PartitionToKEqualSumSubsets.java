package com.deepak.leetCode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionToKEqualSumSubsets {
    // todo : practise this again

    private static int targetSum;
    private static int arrLength;
    private static int[] inputArr;
    Map<String, Boolean> map = new HashMap<>();
    char[] visited;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        // if total sum is not divisible by k, then we cannot create subsets.
        if (totalSum % k != 0)
            return false;

        Arrays.sort(nums);
        reverse(nums);

        inputArr = nums;
        arrLength = nums.length;
        targetSum = totalSum / k;

        visited = new char[arrLength];
        Arrays.fill(visited, '0');

        final boolean b = backTrack(0, 0, 0, k);

        System.out.println("totalSum = " + totalSum);
        System.out.println("targetSum = " + targetSum);
        System.out.println("map = " + map);
        System.out.println("visited = " + Arrays.toString(visited));

        return b;
    }


    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }


    private boolean backTrack(int index, int count, int currSum, int k) {

        // if k-1 subsets are created return true;
        if (count == k - 1)
            return true;


        if (currSum > targetSum)
            return false;

        String currCombination = new String(visited);

        // if already visited, return value;
        if (map.containsKey(currCombination)) {
            return map.get(currCombination);
        }


        if (currSum == targetSum) {
            boolean ans = backTrack(0, count + 1, 0, k);
            map.put(currCombination, ans);
            return ans;
        }

        for (int i = index; i < arrLength; i++) {
            if (visited[i] == '0') {
                visited[i] = '1';
                if (backTrack(i + 1, count, currSum + inputArr[i], k)) {
                    return true;
                }
                visited[i] = '0';
            }
        }
        map.put(currCombination, false);
        return false;
    }

}
