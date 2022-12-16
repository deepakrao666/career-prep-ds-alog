package com.deepak.leetCode.strings;

import java.util.Arrays;
import java.util.Objects;

public class EditDistance {

    public static void main(String[] args) {
        final int i = minDistance("horse", "ros");

        System.out.println(i);
    }

    public static int minDistance(String word1, String word2) {

        if (Objects.equals(word1, word2))
            return 0;

        int m = word1.length();
        int n = word2.length();


        if (m * n == 0)
            return m + n;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                int left = dp[i - 1][j] + 1;
                int up = dp[i][j - 1] + 1;
                int left_up = dp[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_up += 1;
                }

                dp[i][j] = Math.min(left, Math.min(up, left_up));
                System.out.println("dp[i][j] = " + dp[i][j] + ", i = " + i + ", j=" + j);
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[m][n];
    }
}
