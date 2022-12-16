package com.deepak.leetCode.dp;


public class PowerXofN {
    // todo revise FB
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1;
        while (power > 0) {
            if (power % 2 == 1) result *= x;
            x *= x;
            power /= 2;
            //System.out.println("x= " + x + " n=" + n + " r=" + result);
        }
        return result;
    }

}
