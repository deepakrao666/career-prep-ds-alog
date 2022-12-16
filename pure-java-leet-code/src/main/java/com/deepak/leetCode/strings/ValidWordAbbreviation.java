package com.deepak.leetCode.strings;

public class ValidWordAbbreviation {


    public boolean validWordAbbreviation(String word, String abbr) {
        int w = word.length();
        int a = abbr.length();
        int i = 0;
        int j = 0;
        while(i<w && j<a){
            if(word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if(!Character.isDigit(abbr.charAt(j)) || abbr.charAt(j) == '0') return false;
            int temp = 0;
            while(j<a && Character.isDigit(abbr.charAt(j))){
                temp =temp*10+abbr.charAt(j)-'0';
                j +=1;
            }
            while(temp > 0) {
                i +=1;
                temp -=1;
            }
        }
        return i == w && j == a;
    }


}
