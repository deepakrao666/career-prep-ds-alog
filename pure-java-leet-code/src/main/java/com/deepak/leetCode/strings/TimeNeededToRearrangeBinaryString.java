package com.deepak.leetCode.strings;

public class TimeNeededToRearrangeBinaryString {
    public int secondsToRemoveOccurrences(String s) {
        int res = 0;
        for(int i = 0, j = -1, max = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '1') {
                res = Math.max(max, Math.max(res, i - j - 1));
                if(res > 0) {
                    max = res + 1;
                }
                j++;
            }
        }
        return res;
    }

}
