package com.deepak.leetCode.strings;

import java.util.HashMap;
import java.util.Map;

public class VerifyAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }


        for (int i = 0; i < words.length-1; i++) {
            String curr = words[i];
            for (int j = 0; j < curr.length(); j++) {
                if (j >= words[i + 1].length()) return false;
                if (curr.charAt(j) != words[i + 1].charAt(j)) {
                    int currChar = curr.charAt(j) - 'a';
                    int nextChar = words[i + 1].charAt(j) - 'a';
                    if(orderMap[currChar] > orderMap[nextChar])
                        return false;
                    else break;
                }
            }
        }

        return true;
    }

    public boolean isAlienSorted2(String[] words, String order) {
        Map<String, Integer> map = new HashMap<>();

        return true;
    }

}
