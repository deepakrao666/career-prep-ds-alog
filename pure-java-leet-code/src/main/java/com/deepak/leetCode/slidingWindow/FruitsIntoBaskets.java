package com.deepak.leetCode.slidingWindow;

import java.util.HashMap;

public class FruitsIntoBaskets {

    public static void main(String[] args) {

        System.out.println(totalFruit(new int[]{0, 1, 2, 2, 3, 3, 4, 2, 3, 4, 2, 2, 1}));
    }


    public static int totalFruit(int[] fruits) {
        int res = 0;
        int k = 2;
        int i = 0;
        int j = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < fruits.length) {
            map.merge(fruits[j], 1, Integer::sum);

            while (map.size() > k) {
                map.put(fruits[i], map.get(fruits[i]) - 1);

                if (map.get(fruits[i]) == 0)
                    map.remove(fruits[i]);

                i++;
            }

            res = Math.max(res, Math.abs(j - i + 1));
            j++;
        }

        return res;
    }
}
