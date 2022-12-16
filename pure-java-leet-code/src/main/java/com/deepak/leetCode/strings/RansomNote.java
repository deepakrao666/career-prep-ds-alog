package com.deepak.leetCode.strings;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            map.merge(magazine.charAt(i), 1, Integer::sum);
        }
        System.out.println(map);
        for(char c : ransomNote.toCharArray()){
            if(map.containsKey(c)){
                Integer count = map.get(c);
                if(count <= 0){
                    System.out.println(map);
                    return false;
                }
               map.remove(c);
            }else {
                System.out.println(map);
                return false;
            }
        }
        return true;
    }

}
