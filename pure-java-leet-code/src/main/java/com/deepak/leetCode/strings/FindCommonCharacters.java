package com.deepak.leetCode.strings;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public static void main(String[] args) {
        List<String> strings = commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"});

        System.out.println(strings);
    }

    public static List<String> commonChars(String[] words) {

        int[] curr = getCharFreq(words[0]);

        for (int i = 1; i < words.length; i++) {
            int[] target = getCharFreq(words[i]);
            getCommonFreq(curr, target);

        }

        // op
        List<String> res = new ArrayList<>();
        for (int i = 0; i < curr.length; i++) {
            for (int j = 0; j < curr[i]; j++) {
                char c = (char) (i + 'a');
                res.add(Character.toString(c));
            }
        }
        return res;
    }

    private static void getCommonFreq(int[] curr, int[] target) {
        for (int i = 0; i < 26; i++) {
            curr[i] = Math.min(curr[i], target[i]);
        }
    }


    private static int[] getCharFreq(String s) {

        int[] res = new int[26];

        for (int i = 0; i < s.length(); i++) {

            res[s.charAt(i) - 'a']++;

        }
        return res;
    }
}
