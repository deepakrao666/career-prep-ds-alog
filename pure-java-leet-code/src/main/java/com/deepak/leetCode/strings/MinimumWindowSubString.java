package com.deepak.leetCode.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public String minWindow(String targetStr, String sourceStr) {

        Map<Character, Integer> targetMap = populateMap(sourceStr);
        int first = 0;
        int second = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        String minWindow = "";

        while (second < targetStr.length()) {
            while (second < targetStr.length() && !validateWindow(windowMap, targetMap)) {
                char currentChar = targetStr.charAt(second);
                if (targetMap.containsKey(currentChar)) {
                    windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);
                }
                second++;
            }
            while (first < second && validateWindow(windowMap, targetMap)) {
                String currentWindow = targetStr.substring(first, second);
                if (minWindow.isEmpty() || minWindow.length() > currentWindow.length()) {
                    minWindow = currentWindow;
                }
                char currentChar = targetStr.charAt(first);
                if (windowMap.containsKey(currentChar)) {
                    windowMap.put(currentChar, windowMap.get(currentChar) - 1);
                }
                first++;
            }
        }
        return minWindow.isEmpty() ? "" : minWindow;
    }

    private boolean validateWindow(Map<Character, Integer> tempMap, Map<Character, Integer> targetMap) {
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (!tempMap.containsKey(entry.getKey()) || tempMap.get(entry.getKey()) < targetMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> populateMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
