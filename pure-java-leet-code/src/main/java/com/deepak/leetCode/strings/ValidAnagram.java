package com.deepak.leetCode.strings;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for(int i = 0; i < s.length() /2 ; i++){

          if(sArr[i] != tArr[i])
              return false;
        }
        return true;
    }

}
