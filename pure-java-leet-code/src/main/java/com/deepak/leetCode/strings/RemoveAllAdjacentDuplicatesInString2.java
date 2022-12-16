package com.deepak.leetCode.strings;

public class RemoveAllAdjacentDuplicatesInString2 {

    public static void main(String[] args) {
        final String ans = removeDuplicates("pbbcggttciiippooaais", 2);
        System.out.println(ans);
    }

    public static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i-1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}
