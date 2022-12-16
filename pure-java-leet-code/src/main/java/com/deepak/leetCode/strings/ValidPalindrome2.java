package com.deepak.leetCode.strings;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        boolean skip = false;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return checkPalindrome(s, left, right - 1) || checkPalindrome(s, left + 1, right);
            }

            left++;
            right--;
        }
        return true;
    }

    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
