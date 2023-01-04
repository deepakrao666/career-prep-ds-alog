package com.deepak.leetCode.arrays;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumForThreeSum(nums, i, res);
            }
        }
        return res;
    }

    private void twoSumForThreeSum(int[] nums, int start, List<List<Integer>> res) {
        Set<Integer> seen = new HashSet<>();
        for (int i = start + 1; i < nums.length; i++) {
            int diff = -nums[start] - nums[i];
            if (seen.contains(diff)) {
                res.add(Arrays.asList(diff, nums[start], nums[i]));
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            seen.add(nums[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
