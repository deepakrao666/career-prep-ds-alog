package com.deepak.pramp;

import java.util.ArrayList;
import java.util.List;

public class DifferenceBetweenTwoStrings {

    private static int sLen, tLen;
    private static Integer[][] memo;
    private static String s, t;

    static String[] diffBetweenTwoStrings(String source, String target) {
        // your code goes here
        List<String> list = new ArrayList<>();

        s = source;
        t = target;

        sLen = s.length();
        tLen = t.length();

        int[][] dp = new int[sLen + 1][tLen + 1];

        for (int i = 0; i <= sLen; i++)
            dp[i][tLen] = 0;

        for (int j = 0; j <= tLen; j++)
            dp[sLen][j] = 0;


        for(int i = 0; i < sLen; i++){
            for(int j = 0; j < tLen; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = 1+ Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        for(int[] row: dp){
            for (int col: row){
                System.out.print(col + ", ");
            }
            System.out.println();
        }


        String[] res = new String[list.size()];
        list.toArray(res);

        return res;
    }
}
