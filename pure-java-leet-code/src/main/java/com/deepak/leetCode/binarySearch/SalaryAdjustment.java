package com.deepak.leetCode.binarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SalaryAdjustment {

    public static void main(String[] args) {
//        System.out.println(findGrantsCap(new double[]{2, 4}, 3)); // 1.5
//        System.out.println(findGrantsCap(new double[]{2, 4, 6}, 3)); // 1
//        System.out.println(findGrantsCap(new double[]{2, 100, 50, 120, 167}, 400)); // 128
//        System.out.println(findGrantsCap(new double[]{2, 100, 50, 120, 1000}, 190)); // 47
        System.out.println(findGrantsCap(new double[]{21, 100, 50, 120, 130, 110}, 140)); // 23.8
//        System.out.println(findGrantsCap(new double[]{210, 200, 150, 193, 130, 110, 209, 342, 117}, 1530)); // 211
    }

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        Arrays.sort(grantsArray);
        System.out.println("0. "+ Arrays.toString(grantsArray));
        int lo = 0;
        int hi = grantsArray.length - 1;
        double cap = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            cap = checkBudget(grantsArray, mid, newBudget);

            System.out.println("1. mid = " + mid + ", cap = " + cap + ",  grantsArray[mid] = " + grantsArray[mid] + ", condition = " + (cap >= grantsArray[mid]));

            if (cap >= grantsArray[mid])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        // when while loop ends, "hi" in the array is the largest grant that we can pay without cap
        return checkBudget(grantsArray, hi, newBudget);
    }

    static double checkBudget(double[] grantsArray, int mid, double newBudget) {
        double totalBudget = 0;
        for (int i = 0; i < grantsArray.length; i++) {
            if (i <= mid)
                totalBudget += grantsArray[i];
            else {
                newBudget -= totalBudget;

                System.out.println("2. totalBudget = " + totalBudget + ", newBudget = " + newBudget + ", (grantsArray.length - mid - 1) = " + (grantsArray.length - mid - 1));


                return newBudget / (grantsArray.length - mid - 1);
            }
        }
        return -1;
    }


}
