package com.deepak.leetCode.arrays;

import java.util.Arrays;

public class MaxIcecreamBars {

    public int maxIceCream(int[] costs, int coins) {

        int res = 0;

        Arrays.sort(costs);


        for(int i = 0; i < costs.length; i++){

            coins -= costs[i];

            if(coins < 0){
                return res;
            }
            res++;
        }

        return res;
    }
}
