package com.deepak.leetCode.binarySearch;

public class CapacityToShipPackagesWithinNDays {
    private static int[] weights;
    private static int days;

    public int shipWithinDays(int[] weights, int days) {
        CapacityToShipPackagesWithinNDays.weights = weights;
        CapacityToShipPackagesWithinNDays.days = days;

        int lo = 0;
        int hi = 0;

        for (int w : weights) {
            lo = Math.max(w, lo);
            hi += w;
        }
        System.out.println("lo = " + lo);
        System.out.println("hi = " + hi);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (possible(mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

            System.out.println("lo:" + lo + "::hi:" + hi + " , mid = " + mid);
        }
        return lo;
    }

    private boolean possible(int capacity) {
        int tempDay = 1;
        int tempWeight = 0;


        for (int i : weights) {
            if (i > capacity || tempDay > days) {
                System.out.println("capacity less then i or temp > days");
                return false;
            }

            if (tempWeight + i <= capacity) {

                tempWeight += i;

            } else {
                tempWeight = i;
                tempDay++;
            }
        }
        System.out.println("tempDay = "+tempDay + ", tempWeight = "+ tempWeight + ", capacity"+ capacity );
        return tempDay > days;
    }

}
