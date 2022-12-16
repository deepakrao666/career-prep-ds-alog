package com.deepak.leetCode.strings;

import java.util.Arrays;

public class SentenceReverse {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseWords(new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'})));

        System.out.println(Arrays.toString(reverseWords(new char[]{'a', ' ', ' ', 'b'})));

        System.out.println(Arrays.toString(reverseWords(new char[]{'h', 'e', 'l', 'l', 'o'})));

    }


    static char[] reverseWords(char[] arr) {
        // your code goes here
        int n = arr.length;
        swap(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
        int start = 0;
        int end = -1;

        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == ' ' && end != -1) {
                swap(arr, start, end);
                start = i != n - 1 ? i + 1 : i;
                end = -1;
            } else if (i == n - 1) {
                System.out.println("last");
                swap(arr, start, i);
            } else {
                end = i;
            }
        }
        return arr;
    }

    static void swap(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    private static final char SPACE = ' ';


}
