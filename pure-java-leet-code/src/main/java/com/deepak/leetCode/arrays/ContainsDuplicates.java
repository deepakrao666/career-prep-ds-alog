package com.deepak.leetCode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicates {
    Map<Integer, Integer> map = new HashMap<>();

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)){
                Integer pos = map.get(num);
             //   System.out.println(map);
             //   System.out.println(num );
                if(Math.abs(pos - i) <= k)
                    return true;
            }
            map.put(num, i);
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int temp = t-num;

            if(map.containsKey(num)){
                Integer pos = map.get(num);
                //   System.out.println(map);
                //   System.out.println(num );
                if(Math.abs(pos - i) <= k)
                    return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
