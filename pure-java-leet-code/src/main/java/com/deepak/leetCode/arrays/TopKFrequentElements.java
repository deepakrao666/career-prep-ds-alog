package com.deepak.leetCode.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.merge(num, 1, Integer::sum);
        }

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered( e -> sortedMap.put(e.getKey(),e.getValue() ));


        System.out.println(sortedMap);
        int counter = 0;
        for(Integer key : sortedMap.keySet()){
            if(counter == k)
                return res;

            res[counter] = key;

            counter++;
        }

        return res;
    }

}
