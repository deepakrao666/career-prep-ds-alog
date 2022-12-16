package com.deepak.leetCode.binarySearch;

public class KokoEatingBanana {

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;

        for(int i : piles){
            hi = Math.max(hi, i);
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println(mid + " " + lo + " " + hi );
            if (canEatInTime(piles, mid, h))
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }

    public boolean canEatInTime(int[] piles, int mid, int h) {
        int hours = 0;

        for (int i : piles) {

            int div = i / mid;

            hours += div;

            if (i % mid != 0)
                hours++;
        }

        return hours > h;
    }


}
