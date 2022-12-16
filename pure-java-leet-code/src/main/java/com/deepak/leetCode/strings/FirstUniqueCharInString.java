package com.deepak.leetCode.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstUniqueCharInString {


    public int firstUniqChar(String s) {

       int uniquePos = -1;

        Map<Character, Integer> charAndRepeat = new HashMap<>();

       for(int i = 0; i < s.length(); i++){
            charAndRepeat.merge(s.charAt(i), 1, Integer::sum);
       }

       if(!charAndRepeat.containsValue(1)){
           return -1;
       } else {
            uniquePos = Integer.MAX_VALUE;
           Set<Character> collect = charAndRepeat
                   .entrySet()
                   .stream()
                   .filter(e -> e.getValue() == 1)
                   .map(Map.Entry::getKey)
                   .collect(Collectors.toSet());

           for(int i = 0; i < s.length(); i++){

               if(collect.contains(s.charAt(i))){
                   uniquePos = Math.min(uniquePos, i);
               }
           }
       }

       return uniquePos;
    }

}

