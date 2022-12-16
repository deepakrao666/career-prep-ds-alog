package com.deepak.leetCode.heapQueueStack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        final int[] ints = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // base
        if (nums.length * k == 0) return new int[0];
        if (k == 1) return nums;

        // init
        int maxIndex = 0;
        ArrayDeque<Integer> queueOfIndices = new ArrayDeque<>();

        // for 0 to k-1 array
        for (int i = 0; i < k; i++) {
            cleanQueue(i, k, queueOfIndices, nums);
            queueOfIndices.addLast(i);
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }

        // init result[0]
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[maxIndex];

        // for rest of array.
        for (int i = k; i < nums.length; i++) {
            cleanQueue(i, k, queueOfIndices, nums);
            queueOfIndices.addLast(i);

            // from i-0 == 0  to length -1
            // getFirst always stores max value of window.
            res[i - k + 1] = nums[queueOfIndices.getFirst()];
        }

        return res;
    }

    private void cleanQueue(int i, int k, ArrayDeque<Integer> queue, int[] nums) {
        if (!queue.isEmpty() && queue.getFirst() == i - k) {
            queue.removeFirst();
        }
        while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
            queue.removeLast();
        }
    }

}
