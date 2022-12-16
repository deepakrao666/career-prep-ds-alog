package com.deepak.leetCode.dp;
import java.util.HashMap;
import java.util.Map;

public class FindNumberOfStepsToReachOne {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int steps = findSteps(5);

        System.out.println(steps);
        System.out.println(map);
    }

    public static int findSteps(int n) {
        int res = 0;
        int input = n;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            res++;
        }
        map.put(input, res);
        return res;
    }
}
