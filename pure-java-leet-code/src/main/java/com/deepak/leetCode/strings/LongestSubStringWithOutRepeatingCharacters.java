package com.deepak.leetCode.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithOutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0)
            return 0;

        int max = 0, right = 0, left = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, set.size());
            right++;
        }

        return max;
    }
}
