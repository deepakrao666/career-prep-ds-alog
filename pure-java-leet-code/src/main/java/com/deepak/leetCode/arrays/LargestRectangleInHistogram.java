package com.deepak.leetCode.arrays;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        return calculateArea(heights, 0, heights.length - 1);
    }

    private int calculateArea(int[] heights, int start, int end) {
        System.out.println("start = " + start + ", end = " + end);
        if (start > end)
            return 0;

        int minIndex = start;

        for (int i = start; i <= end; i++) {
            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }


        int width = heights[minIndex] * (end - start + 1);
        int leftArea = calculateArea(heights, start, minIndex - 1);
        int rightArea = calculateArea(heights, minIndex + 1, end);

        System.out.println("minIndex = " + minIndex
                +", width = " + width
                +", leftArea = " + leftArea
                +", rightArea = " + rightArea
        );

        return Math.max(width, Math.max(leftArea, rightArea));

    }
}
