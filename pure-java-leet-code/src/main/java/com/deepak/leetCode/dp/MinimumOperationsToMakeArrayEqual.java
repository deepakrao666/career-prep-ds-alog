package com.deepak.leetCode.dp;


public class MinimumOperationsToMakeArrayEqual {

    public static void main(String[] args) {
        minOperations(6);
    }

    public static int minOperations(int n) {

        return n % 2 == 0 ? n * n / 4 : (n * n - 1) / 4;
    }
}
