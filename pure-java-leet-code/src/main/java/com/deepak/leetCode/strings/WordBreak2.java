package com.deepak.leetCode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {


    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<Character> stringCharSet = new HashSet<>();
        HashSet<Character> wordCharSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();

        updateCharSet(s, stringCharSet);
        for (String word : wordDict) {
            wordSet.add(word);
            updateCharSet(word, wordCharSet);
        }

        // quick check on the sets of characters
        if (!wordCharSet.containsAll(stringCharSet))
            return new ArrayList<>();

        List<List<String>> dp = new ArrayList<>(s.length() + 1);
        for (int i = 0; i < s.length() + 1; ++i) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");

        for (int endIndex = 1; endIndex < s.length() + 1; endIndex++) {
            ArrayList<String> sublist = new ArrayList<>();

            // fill up the values in the dp array.
            for (int startIndex = 0; startIndex < endIndex; startIndex++) {
                String word = s.substring(startIndex, endIndex);
                if (wordSet.contains(word))
                    for (String subSentence : dp.get(startIndex))
                        sublist.add((subSentence + " " + word).trim());
            }
            dp.set(endIndex, sublist);
        }
        return dp.get(s.length());
    }

    private void updateCharSet(String s, HashSet<Character> charSet) {
        for (int i = 0; i < s.length(); i++)
            charSet.add(s.charAt(i));
    }
}
