package com.deepak.leetCode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        // To crack this problem, we need to understand that
        // k operations are applicable
        // if the current window size minus the frequency of the most frequent character is less or equal to k
        // window size - most freq char <= k

        int res = 0, i = 0, j = 0, n = s.length();
        int mostFreqChar = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        while (j < n) {
            char curr = s.charAt(j);

            // Store each character along with its frequency
            // and get the most freq char in the current window
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            mostFreqChar = Math.max(mostFreqChar, map.get(curr));

            if (j - i - mostFreqChar + 1 <= k) {
                res = Math.max(res, j - i + 1);
            } else {
                // Move the left pointer to the next character
                // and update its frequency in map
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }
            j++;
        }

        return res;
    }
}
