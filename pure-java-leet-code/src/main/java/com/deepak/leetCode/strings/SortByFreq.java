package com.deepak.leetCode.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortByFreq {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        System.out.println(map);

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println(sortedMap);
        sortedMap.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                sb.append(k);
            }
        });

        return sb.toString();
    }
}
