package com.deepak.leetCode.dp;


public class MinimumPossibleIntAfterMostKAdjSwap {
    // todo revise FB

    public static void main(String[] args) {

        final String s = minInteger("12345", 4);
        System.out.println(s);
    }

    public static String minInteger(String num, int k) {
        char[] array = num.toCharArray();
        int length = num.length();

        int pointer = 0;

        while (k > 0 && pointer < length) {
            // System.out.println("pointer = " + pointer);
            int min = array[pointer] - '0';
            int minPos = pointer;

            // if k is large, i.e. pointer + k it too larger
            // then run out of range,
            // get max possible i.e. length -1
            int limit = Math.min(length - 1, pointer + k);
            // System.out.println("length - 1 = " + (length - 1) + ", pointer + k = " + (pointer + k));
            // System.out.println("limit = " + limit);


            // get min
            for (int i = pointer + 1; i <= limit; i++) {
                int temp =array[i] - '0';
                if (temp < min) {
                    min = temp;
                    minPos = i;
                }
            }

            // System.out.println("min = " + min + ", minPos = " + minPos);
            // System.out.println("(minPos - pointer) = " + (minPos - pointer));
            k = k - (minPos - pointer);
            //System.out.println("k = " + k);

            // get min char
            char c = array[minPos];

            // move min char to pointer char
            // System.out.println("before swap = " + Arrays.toString(array));
            for (int i = minPos - 1; i >= pointer; i--)
                array[i + 1] = array[i];
            // System.out.println("after swap = " + Arrays.toString(array));
            array[pointer] = c;
            // System.out.println("after set = " + Arrays.toString(array));
            pointer++;
            //System.out.println("--");
        }

        return new String(array);
    }
}
