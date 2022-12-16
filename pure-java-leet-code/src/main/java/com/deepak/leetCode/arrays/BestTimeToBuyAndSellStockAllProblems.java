package com.deepak.leetCode.arrays;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockAllProblems {

    public static void main(String[] args) {
        int i = maxProfit(new int[]{3,3,5,0,0,3,1,4});
        System.out.println("result = " + (i == 6));

        System.out.println("----");
        i = maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println("result = " + (i == 4));

    }

    // 123. Best Time to Buy and Sell Stock III
    public static int maxProfit(int[] prices) {
        System.out.println("ip = "+ Arrays.toString(prices));
        int max = 0;
        int n = prices.length;

        int buyPos = 0;
        int sellPos = 0;


        for(int i = 1; i < n; i++){


            if(prices[i] <= prices[buyPos]){
                buyPos = i;
            }else {
                sellPos = i;
            }




        }


        System.out.println(max);
        return max;
    }

 // 122. Best Time to Buy and Sell Stock II
    public static int maxProfit2(int[] prices) {

        int max = 0;

        for (int i =1; i < prices.length; i++){

            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }

        return max;
    }



    // 121. Best Time to Buy and Sell Stock
    public int maxProfit1(int[] prices) {
        // 7 8 9 1 2 3 4
        int buyPos = 0;
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[buyPos]) {
                buyPos = i;
            } else if (prices[i] - prices[buyPos] > res) {
                res = prices[i] - prices[buyPos];
            }
        }
        return res;
    }

}
