package com.deepak.leetCode.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctChars {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        char first = s.charAt(0), second = s.charAt(1);

        int left = 2;
        int right = 2;

        while (right < s.length()) {
            res = Math.max(res, right - left + 1);


            char c = s.charAt(right);
            map.merge(c, 1, Integer::sum);

            if (first == second && second != c) {
                second = c;
            }

            if (c != first || c != second) {
                left = right;
                first = c;
            }

            right++;
        }

        System.out.println(map);

        return res;
    }
}
