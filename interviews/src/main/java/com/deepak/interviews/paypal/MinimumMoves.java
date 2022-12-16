package com.deepak.interviews.paypal;

import java.util.Arrays;
import java.util.List;

public class MinimumMoves {


    public static void main(String[] args) {
        //System.out.println(Arrays.toString(convertNumberToIntArray(4567)));

        // System.out.println(minimumMoves(Arrays.asList(1234, 4321), Arrays.asList(2345, 3214)));


        System.out.println(doThis(new int[]{1234, 4321}, new int[]{2345, 3214}));
    }


    public static int minimumMoves(List<Integer> src, List<Integer> target) {
        int result = 0;

        for (int i = 0; i < src.size(); i++) {

            int currSrc = src.get(i);
            int currTarget = target.get(i);

            while (currSrc > 0) {

                int digitSrc = currSrc % 10;
                int digitTarget = currTarget % 10;
                result += Math.abs(digitSrc - digitTarget);

                currSrc = (currSrc - digitSrc) / 10;
                currTarget = (currTarget - digitTarget) / 10;

            }
        }

        return result;
    }

    private static int compute(int[] src, int[] target) {
        int res = 0;

        Arrays.sort(src);
        Arrays.sort(target);

        for (int i = 0; i < src.length; i++) {

            if (src[i] != target[i])
                res += Math.abs(src[i] - target[i]);
        }

        System.out.println("after compute = " + res);

        return res;
    }

    private static int[] convertNumberToIntArray(Integer num) {

        String temp = Integer.toString(num);
        int[] arr = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            arr[i] = temp.charAt(i) - '0';
        }
        return arr;
    }


    private static int doThis(int[] a, int[] m) {
        Integer numMoves1 = 0, numMoves2 = 0;
        Integer num1 = 0, num2 = 0;
        Integer digit1 = 0, digit2 = 0;
        //Forward
        for (Integer i = 0; i < a.length; i++) {
            num1 = a[i];
            num2 = m[i];
            for (Integer j = 0; j < a.length; j++) {
                digit1 = num1 % 10;
                digit2 = num2 % 10;
                numMoves1 += Math.abs(digit1 - digit2);
                num1 = (num1 - digit1) / 10;
                num2 = (num2 - digit2) / 10;
            }
        }
        //Backward
        for (Integer i = 0; i < a.length; i++) {
            num1 = m[i];
            num2 = a[i];
            for (Integer j = 0; j < a.length; j++) {
                digit1 = num1 % 10;
                digit2 = num2 % 10;
                numMoves2 += Math.abs(digit1 - digit2);
                num1 = (num1 - digit1) / 10;
                num2 = (num2 - digit2) / 10;
            }
        }
        if (numMoves1 > numMoves2) {
            return numMoves1;
        } else if (numMoves1 < numMoves2) {
            return numMoves2;
        } else {
            return numMoves1;
        }
    }
}
