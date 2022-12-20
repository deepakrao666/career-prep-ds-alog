package com.deepak.leetCode.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithOutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));


    }
    public static  int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int max = 0;
        int j = 0;
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            // add element to map
            String log = String.format(" (j - i + 1) = %1d", (j - i + 1) );
            System.out.println(log);
            map.merge(s.charAt(j), 1, Integer::sum);
            if (map.size() == j - i + 1) {
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                while (map.size() < j - i + 1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0){
                       map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }

        // return
        return max;
    }
}
