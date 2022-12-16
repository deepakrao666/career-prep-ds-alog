package com.deepak.leetCode.dp;

import java.util.*;

public class ColorfulNumbers {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(getColorFul(3245));
    }

    public static int getColorFul(int A) {

        HashSet<Integer> check = new HashSet<>();
        String str = Integer.toString(A);

        for(int i=0;i<str.length();i++){
            int product = 1;
            for(int j=i; j<str.length();j++){
                int num = str.charAt(j) - '0';
                product *= num;
                if(check.contains(product)) return 0;
                check.add(product);
            }
        }
        List<Integer> sortedList = new ArrayList<>(check);
        Collections.sort(sortedList);
        System.out.println(sortedList);

        return 1;
    }
}
