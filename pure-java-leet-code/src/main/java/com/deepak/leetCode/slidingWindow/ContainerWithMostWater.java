package com.deepak.leetCode.slidingWindow;

public class ContainerWithMostWater {


    public int maxArea(int[] height) {
        if (height.length == 2) return Math.min(height[0], height[1]);

        int left = 0, right = height.length - 1;
        int res = 0;

        while (left < right) {

            int dist = right - left;
            int area = Math.min(height[left], height[right]) * dist;

            res = Math.max(res, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }


//    public int maxArea(int[] height) {
//        return maxAreaWithWindow(height);
//    }
//
//    private int maxAreaWithWindow(int[] height) {
//        if (height.length == 2) return Math.min(height[0], height[1]);
//        int res = 0;
//
//
//        int left = 0;
//        int right = height.length - 1;
//
//        while (left < right) {
//
//            int dist = right - left;
//            int area = Math.min(height[left], height[right]) * dist;
//
//            res = Math.max(res, area);
//
//            if (height[left] <= height[right])
//                left++;
//            else
//                right--;
//        }
//
//        return res;
//    }
}
