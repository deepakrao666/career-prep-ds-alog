package com.deepak.leetCode.strings;

import java.util.Arrays;

public class LongestPalindrome {


    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int len = 0; len < n; len++) {
            for (int left = 0; left + len < n; left++) {

                int right = left + len;

                dp[left][right] = s.charAt(left) == s.charAt(right) && (len < 2 || dp[left + 1][right - 1]);

                if (dp[left][right] && len > end - start) {
                    System.out.print(" len = " + len);
                    System.out.print(", start = " + start);
                    System.out.print(", end = "+end);
                    System.out.print(", left = "+left);
                    System.out.println(", right = "+right);

                    start = left;
                    end = right;
                }
            }
        }

        for (boolean[] row : dp)
            System.out.println(Arrays.toString(row));

        return s.substring(start, end + 1);
    }

    public String longestPalindromeWithExpandAroundCenter(String s) {

        if (s == null || s.length() == 0)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }


        return r - l - 1;
    }
}
