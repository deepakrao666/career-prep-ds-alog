package com.deepak.leetCode.slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eaebc", 2));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int i = 0;
        int j = 0;
        int res = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();


        while (j < n) {
            char curr = s.charAt(j);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while (map.size() > k) {
                char remove = s.charAt(i);
                if (map.containsKey(remove)) {
                    map.put(remove, map.get(remove) - 1);
                    if (map.get(remove) == 0) map.remove(remove);
                }
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}
