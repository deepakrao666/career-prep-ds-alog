package com.deepak.leetCode.strings;

public class MinimumNumberOfStepsToMakeAnagram {

    // todo : doordash

    public static void main(String[] args) {
        System.out.println(minSteps("aba", "bab"));
    }

    public static int minSteps(String s, String t) {
        int res = 0;
        int[] memo = new int[26];

        for (int i = 0; i < s.length(); i++) {
            memo[s.charAt(i) - 'a']++;
            memo[t.charAt(i) - 'a']--;
        }

        for (int i : memo) {
            res += Math.abs(i);
        }

        return res / 2;
    }
}
