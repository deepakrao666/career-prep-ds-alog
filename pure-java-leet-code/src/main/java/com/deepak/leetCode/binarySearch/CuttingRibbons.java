package com.deepak.leetCode.binarySearch;

public class CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {

        int max = Integer.MIN_VALUE ;

        for (int ribbon : ribbons) {
            max = Math.max(max, ribbon);
        }

        int lo = 0 ;
        int high = max ;

        int ans = 0 ;

        while(lo <= high){
            int mid = lo + (high-lo)/2 ;
            if(isPossible(ribbons , mid , k)){
                ans = mid ;
                lo = mid+1 ;
            }else{
                high = mid-1 ;
            }
        }

        return ans ;
    }

    public boolean isPossible(int[] ribbons , int length , int k){

        if(length == 0){
            return true ;
        }

        int count = 0 ;

        for (int ribbon : ribbons) {
            if (length <= ribbon) {
                count += ribbon / length;
            }
            if (count >= k) {
                return true;
            }
        }

        return false ;
    }

}
