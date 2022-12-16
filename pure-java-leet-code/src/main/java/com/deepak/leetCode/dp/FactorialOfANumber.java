package com.deepak.leetCode.dp;


import java.util.ArrayList;
import java.util.List;

public class FactorialOfANumber {

    private static List<Double> dp = new ArrayList<>();


    public static void main(String[] args) {
        dp.add(0, 0d);
        dp.add(1, 1d);
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println(factorial(20));

        System.out.println(compute(new int[]{3, 4, 5}));

        System.out.println("--");
        for (int i = 0; i < dp.size(); i++) {
            System.out.println(i + ":" + dp.get(i));
        }
    }

    private static int compute(int[] numbers) {
        int res = 0;
        for (int n : numbers) {
            int startIndex = dp.size();

            for (int i = startIndex; i <= n; i++) {
                dp.add(i, dp.get(i - 1) * i);
            }
            res += dp.get(n);
        }
        System.out.println( res % 107);
        return res % 107;
    }

    private static double factorial(int k) {

        int startIndex = dp.size();

        for (int i = startIndex; i <= k; i++) {
            dp.add(i, dp.get(i - 1) * i);
        }
        return dp.get(k);
    }
}
