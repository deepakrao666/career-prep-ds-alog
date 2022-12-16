package com.deepak.leetCode.dp;


public class CountAllValidPickUpAndDeliveryOptions {

    // TODO : doordash

    /*
    probability (P) = no of favorable outcomes / total no of outcomes
    no of favorable outcomes = probability * total no of outcomes

    total no of outcomes = (2N)!

    no of favorable outcomes = (2N)!/2^N

     */

    public int countOrders(int n) {
        long ans = 1;
        int MOD = 1_000_000_007;

        for (int i = 1; i <= n; ++i) {
            // Ways to arrange all pickups, 1*2*3*4*5*...*n
            ans = ans * i;
            // Ways to arrange all deliveries, 1*3*5*...*(2n-1)
            ans = ans * (2L * i - 1);
            ans %= MOD;
        }

        return (int)ans;
    }


    private int MOD = 1_000_000_007;
    private long[][] memo;

    public int countOrdersMemo(int n) {
        memo = new long[n + 1][n + 1];
        return (int)totalWays(n, n);
    }


    private long totalWays(int unpicked, int undelivered) {
        if (unpicked == 0 && undelivered == 0) {
            // We have completed all orders.
            return 1;
        }

        if (unpicked < 0 || undelivered < 0 || undelivered < unpicked) {
            // We can't pick or deliver more than N items
            // Number of deliveries can't exceed number of pickups
            // as we can only deliver after a pickup.
            return 0;
        }

        if (memo[unpicked][undelivered] != 0) {
            // Return cached value, if already present.
            return memo[unpicked][undelivered];
        }

        long ans = 0;

        // Count all choices of picking up an order.
        ans += unpicked * totalWays(unpicked - 1, undelivered);
        // Handle integer overflow.
        ans %= MOD;

        // Count all choices of delivering a picked order.
        ans += (undelivered - unpicked) * totalWays(unpicked, undelivered - 1);
        // Handle integer overflow.
        ans %= MOD;

        return memo[unpicked][undelivered] = ans;
    }


}
