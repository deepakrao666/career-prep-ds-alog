package com.deepak.leetCode.arrays;

public class LookAndSay {
    public static void main(String[] args) {

        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String res = "1";
        if (n == 1)
            return res;

        for (int i = 1; i < n; i++) {
            res = generate(res);
        }

        return res;

    }

    private static String generate(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int freq = 1;

            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                freq++;
                i++;
            }
            sb.append(freq).append(s.charAt(i));
        }

        System.out.println(sb);
        return sb.toString();
    }


}
