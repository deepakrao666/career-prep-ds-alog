package com.deepak.leetCode.arrays;

import java.util.*;

public class RandomPickWithIndex {
    // todo revise FB

    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] nums;
    Random random;

    public RandomPickWithIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new LinkedList<>());
            }
            map.get(nums[i]).add(i);
        }
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        final List<Integer> list = map.get(target);
        final int size = list.size();
        return list.get(random.nextInt(size));
    }

}
