package com.deepak.leetCode.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];

        boolean b = wordBreakMemo(s, dict, 0, memo);

        System.out.println(dict);
        System.out.println(Arrays.toString(memo));

        return b;
    }

    private boolean wordBreakMemo(String s, HashSet<String> dict, int start, Boolean[] memo) {

        if (start == s.length())
            return true;

        if (memo[start] != null)
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {

            if (dict.contains(s.substring(start, end)) && wordBreakMemo(s, dict, end, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }

}
