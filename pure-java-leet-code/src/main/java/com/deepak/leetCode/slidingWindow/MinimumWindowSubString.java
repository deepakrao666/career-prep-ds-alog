package com.deepak.leetCode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String source, String target) {

        int sourceLength = source.length();
        int targetLength = target.length();

        Map<Character, Integer> required = new HashMap<>();

        for (char c : target.toCharArray()) {
            required.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> acquired = new HashMap<>();

        int min = Integer.MAX_VALUE;
        String ans = "";

        int left = 0, right = 0;
        int found = 0;

        while (left < sourceLength) {

            while (right < sourceLength && found != targetLength) {
                char curr = source.charAt(right);
                if (required.containsKey(curr)) {
                    acquired.put(curr, acquired.getOrDefault(curr, 0) + 1);

                    if (acquired.get(curr) <= required.get(curr)) {
                        found += 1;
                    }
                }
                right++;
            }

            int windowSize = right - left;

            if (found == targetLength && windowSize < min) {
                min = windowSize;
                ans = source.substring(left, right);
            }

            if (required.containsKey(source.charAt(left))) {
                acquired.put(source.charAt(left), acquired.getOrDefault(source.charAt(left), 0) - 1);

                if(acquired.get(source.charAt(left)) < required.get(source.charAt(left))){
                    found -= 1;
                }
            }

            left++;
        }

        return ans;
    }

}
