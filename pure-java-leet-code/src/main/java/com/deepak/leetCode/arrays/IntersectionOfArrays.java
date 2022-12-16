package com.deepak.leetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays {

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }

        int[] resArr = new int[res.size()];

        for(int e = 0; e < res.size(); e++){
            resArr[e] = res.get(e);
        }

        return resArr;

    }
}
