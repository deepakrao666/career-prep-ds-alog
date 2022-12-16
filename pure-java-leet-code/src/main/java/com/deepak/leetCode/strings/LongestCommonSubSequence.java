package com.deepak.leetCode.strings;

import java.util.Arrays;

public class LongestCommonSubSequence {

    public int longestCommonSubsequence(String shortText, String longText) {

        // If shortText doesn't reference the shortest string, swap them.
        if (longText.length() < shortText.length()) {
            String temp = shortText;
            shortText = longText;
            longText = temp;
        }

        // The previous and current column starts with all 0's and like
        // before is 1 more than the length of the first word.
        int[] previous = new int[shortText.length() + 1];
        int[] current = new int[shortText.length() + 1];

        // Iterate through each column, starting from the last one.
        for (int col = longText.length() - 1; col >= 0; col--) {
            for (int row = shortText.length() - 1; row >= 0; row--) {
                if (shortText.charAt(row) == longText.charAt(col)) {
                    current[row] = 1 + previous[row + 1];
                } else {
                    current[row] = Math.max(previous[row], current[row + 1]);
                }
            }
            // The current column becomes the previous one, and vice versa.
            int[] temp = previous;
            previous = current;
            current = temp;
        }

        System.out.println(Arrays.toString(previous));
        // The original problem's answer is in previous[0]. Return it.
        return previous[0];
    }
}
