package com.deepak.leetCode.slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctChars {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();

        int res = 2;

        while (j < n) {
            map.put(s.charAt(j), j++);
            if (map.size() == 3) {
                int remove = Collections.min(map.values());
                map.remove(s.charAt(remove));
                i = remove;
            }

            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
