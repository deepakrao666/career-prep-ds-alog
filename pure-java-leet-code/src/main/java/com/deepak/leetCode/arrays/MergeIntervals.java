package com.deepak.leetCode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        System.out.println(Arrays.deepToString(intervals));

        LinkedList<int[]> list = new LinkedList<>();

        for(int[] interval: intervals){
            if(list.isEmpty() || list.getLast()[1] < interval[0]){
                list.add(interval);
            }else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }

        list.forEach( e -> System.out.println(e[0] + ","+e[1]));

        return list.toArray(new int[list.size()][2]);
    }
}
