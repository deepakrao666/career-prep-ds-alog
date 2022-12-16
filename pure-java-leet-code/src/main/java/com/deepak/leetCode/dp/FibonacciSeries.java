package com.deepak.leetCode.dp;


import java.util.LinkedList;
import java.util.List;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(fibonacci(4));
        System.out.println(series);
        System.out.println(fibonacci(2));
        System.out.println(series);
        System.out.println(fibonacci(5));
        System.out.println(series);
        System.out.println(fibonacci(8));

        System.out.println(series);
    }

    private static List<Integer> series = new LinkedList<>();

    public static int fibonacci(int n) {
        if (series.size() < 2) {
            series.add(0);
            series.add(1);
        }
        for (int i = series.size(); i <= n; i++) {
            series.add(series.get(i - 2) + series.get(i - 1));
        }

        return series.get(n);
    }


}
