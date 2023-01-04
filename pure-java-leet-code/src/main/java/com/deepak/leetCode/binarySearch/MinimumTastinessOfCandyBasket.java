package com.deepak.leetCode.binarySearch;

import java.util.Arrays;

public class MinimumTastinessOfCandyBasket {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        //array is sorted this will give the maximum difference b/w max and min value

        //obviously minimum gap between the highest and lowest is 0
        int lo = 0;
        int hi = price[price.length - 1] - price[0];

        int res = 0;

        while (lo <= hi) {
            // get the mid in the price
            int mid = lo + (hi - lo) / 2;

            // use a helper function which returns true of false . I will explain below why we use that here
            if (help(price, mid, k)) {
                // when res = mid , it means res having the minimum gap because that's only returned from the helper function. Now check for others
                res = mid;
                lo = mid + 1;
            } else {
                //res doesn't have the minimum gap so check left of the array because there only less value price.
                hi = mid - 1;
            }

        }
        return res;
    }

    // so basic idea of using this helper function to decide when we are getting the minimum gap between two prices inside the array.
    boolean help(int[] price, int gapPrice, int k) {
        // this if for counting .
        // Starts from 1 because price[0] is the minimum, and we are starting from i = 1.
        int count = 1;
        int lastMin = price[0];

        for (int i = 1; i < price.length; i++) {
            // now count for gaps greater than our mid
            if (price[i] - lastMin >= gapPrice) {
                count++;
                lastMin = price[i];
            }
        }
        // if count exceeds the k then its true otherwise false
        return count >= k;
    }

}
