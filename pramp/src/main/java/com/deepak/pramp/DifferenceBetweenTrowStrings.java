package com.deepak.pramp;

import java.util.ArrayList;
import java.util.List;

public class DifferenceBetweenTrowStrings {
    private static int sLen, tLen;
    private static Integer[][] memo;
    private static String s, t;

    static String[] diffBetweenTwoStrings(String source, String target) {
        List<String> list = new ArrayList<>();
        int i = 0, j = 0;

        s = source;
        t = target;

        sLen = s.length();
        tLen = t.length();

        memo = new Integer[sLen][tLen];

        while (i < sLen && j < tLen)
            if (s.charAt(i) == t.charAt(j)) {
                list.add("" + s.charAt(i));
                i++;
                j++;
            } else {

                if (dp(i + 1, j) <= dp(i, j + 1)) {
                    list.add("-" + s.charAt(i));
                    i++;
                } else {
                    list.add("+" + s.charAt(j));
                    j++;
                }
            }

        while (j < tLen) {
            list.add("+" + t.charAt(j));
        }

        for(Integer[] row: memo){
            for (Integer col: row){
                System.out.print(col + ", ");
            }
            System.out.println();
        }

        String[] res = new String[list.size()];
        list.toArray(res);

        return res;
    }

    private static int dp(int i, int j) {

        if (i == sLen || j == tLen) {
            return tLen - j;
        } else {
            if (memo[i][j] == null) {

                if (s.charAt(i) == t.charAt(j)) {
                    memo[i][j] = dp(i + 1, j + 1);
                } else {
                    memo[i][j] = 1 + Math.min(dp(i + 1, j), dp(i, j + 1));
                }

            }
        }
        return memo[i][j];
    }
}
