package com.deepak.leetCode.arrays;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {

    public static int oddEvenJumps(int[] arr) {
        int n = arr.length;

        boolean[] hi = new boolean[n];
        boolean[] lo = new boolean[n];

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        // init
        treeMap.put(arr[n - 1], n - 1);
        hi[n - 1] = true;
        lo[n - 1] = true;
        int res = 1;


        for (int i = n - 2; i > 0; i--) {

            Map.Entry<Integer, Integer> ceiling = treeMap.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> floor = treeMap.floorEntry(arr[i]);

            if (ceiling != null) {
                hi[i] = lo[ceiling.getValue()];
            }
            if (floor != null) {
                lo[i] = hi[floor.getValue()];
            }

            if (hi[i]) {
                res++;
            }
            treeMap.put(arr[i], i);
        }

        return res;
    }

}
