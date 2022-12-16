package com.deepak.leetCode.arrays;

import java.util.Arrays;

public class TwoCityScheduling {

    // todo : doordash

    public int twoCitySchedCost(int[][] costs) {
        int max = 0;
        int n = costs.length / 2;

        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));

        System.out.println(Arrays.deepToString(costs));

        for (int i = 0; i < n; i++) {
            max += costs[i][0] + costs[n + i][1];
        }

        return max;
    }


//    public int twoCitySchedCost(int[][] costs) {
//
//        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));
//        System.out.println(Arrays.deepToString(costs));
//
//        int total = 0;
//        int n = costs.length / 2;
//
//        for (int i = 0; i < n; ++i){
//            total += costs[i][0] + costs[i + n][1];
//            System.out.println(total);
//        }
//        return total;
//    }
}
