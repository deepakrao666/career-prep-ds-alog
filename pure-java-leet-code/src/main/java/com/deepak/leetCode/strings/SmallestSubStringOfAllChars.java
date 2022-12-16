package com.deepak.leetCode.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SmallestSubStringOfAllChars {
    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring(new char[]{'x','y','z'}, "xyyzyzyx"));
    }
    public static String getShortestUniqueSubstring(char[] arr, String str) {
        Map<Character, Integer> mainFreq = new HashMap<>();

        for (char c : arr) {
            mainFreq.merge(c, 1, Integer::sum);
        }

        int lo = 0;
        int hi = arr.length - 1;

        while (hi < str.length()) {
            Map<Character, Integer> tempFreq = new HashMap<>();

            for (int i = lo; i <= hi; i++) {
                tempFreq.merge(str.charAt(i), 1, Integer::sum);
            }

            lo++;
            hi++;

            Set<Character> keySet = mainFreq.keySet();
            Set<Character> tempKeySet = tempFreq.keySet();

            System.out.println(keySet +", temp ="+tempKeySet);
            boolean leave = false;

            if (!keySet.containsAll(tempKeySet)) {
                leave = true;
            } else {

                for (Character c : keySet) {
                    if (!leave && !tempFreq.containsKey(c)) {
                        leave = true;
                    }

                    if (!leave && !Objects.equals(tempFreq.get(c), mainFreq.get(c))) {
                        leave = true;
                    }
                }
            }

            if (!leave)
                return str.substring(lo-1, hi );

        }

        return "";
    }

}
