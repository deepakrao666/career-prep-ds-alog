package com.deepak.leetCode.arrays;

import java.util.Arrays;

public class TrappingRainWater {
    public int trap(int[] height) {

        int length = height.length;
        int[] rainLeft = new int[length];
        int[] rainRight = new int[length];

        rainLeft[0] = height[0];
        for (int i = 1; i < length; i++) {
            rainLeft[i] = Math.max(rainLeft[i - 1], height[i]);
        }
        System.out.println(Arrays.toString(rainLeft));

        rainRight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rainRight[i] = Math.max(rainRight[i + 1], height[i]);
        }
        System.out.println(Arrays.toString(rainRight));


        int max = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int localMax = Math.min(rainLeft[i - 1], rainRight[i + 1]);
            System.out.print(localMax + " ");

            if (localMax > height[i])
                max += (localMax - height[i]);
        }

        return max;
    }

}
