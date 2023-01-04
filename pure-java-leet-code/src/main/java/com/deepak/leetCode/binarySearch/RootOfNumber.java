package com.deepak.leetCode.binarySearch;

public class RootOfNumber {

    static double root(double x, int n) {
        // your code goes here
        System.out.println("start");
        double lo = 0;
        double hi = x;
        double margin = 0.001;

        while (hi - lo >= margin) {
            double mid = lo + (hi - lo) / 2;

            double pow = 1;
            for (double i = 0; i < n; i++) {
                pow *= mid;
            }
            System.out.println("pow = " + pow + ", mid =  " + mid + ", lo = " + lo + ", hi = " + hi);

            if (pow <= x) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        System.out.println("final result  = " + (lo + (hi - lo) / 2));
        System.out.println("end");

        return lo;
    }
}
