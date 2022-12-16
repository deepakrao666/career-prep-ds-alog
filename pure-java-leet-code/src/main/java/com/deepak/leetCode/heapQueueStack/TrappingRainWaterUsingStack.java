package com.deepak.leetCode.heapQueueStack;

import java.util.Stack;

public class TrappingRainWaterUsingStack {
    public static int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int length = height.length;
        for (int index = 0; index < length; index++) {
            int peek = height[stack.peek()];
            int curr = height[index];

            while (stack.size() > 0 && peek <= curr) {
                int valueAtPop = height[stack.pop()];

                if (stack.size() == 0) {
                    break;
                }
                int leftMax = stack.peek();

                int distance = index - leftMax - 1;
                int boundedHeight = Math.min(height[leftMax], curr) - valueAtPop;

                ans += boundedHeight * distance;
            }
            stack.push(index);
        }

        return ans;
    }

}
