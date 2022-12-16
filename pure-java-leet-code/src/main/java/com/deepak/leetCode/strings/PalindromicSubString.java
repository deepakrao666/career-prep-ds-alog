package com.deepak.leetCode.strings;

public class PalindromicSubString {

    // todo : doordash

    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            ans += countPalindrome(s, i, i);
            ans += countPalindrome(s, i, i + 1);

        }

        return ans;
    }

    private int countPalindrome(String s, int lo, int hi) {
        int ans = 0;

        while (lo >= 0 && hi < s.length()) {

            if (s.charAt(lo) != s.charAt(hi)) {
                break;
            } else {
                // since i == index
                // lo and high start with center indices
                // we expand around the center
                lo--;
                hi++;
                ans++;
            }
        }

        return 0;
    }

}
