package com.deepak.leetCode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        return withPriorityQueue(points, k);
    }

    private static int[][] withPriorityQueue(int[][] points, int k) {
        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {
            int[] entry = new int[]{squareValue(points[i]), i};

            if (priorityQueue.size() < k) {
                priorityQueue.add(entry);
            } else if (!priorityQueue.isEmpty() && entry[0] < priorityQueue.peek()[0]) {
                int[] poll = priorityQueue.poll();
                System.out.println("polled value = " + poll[0] + ":" + poll[1]);
                priorityQueue.add(entry);
            }
        }

        int[][] res = new int[k][2];

        System.out.println(Arrays.toString(priorityQueue.peek()));
        for (int i = 0; i < k; i++) {
            if (!priorityQueue.isEmpty()) {
                int index = priorityQueue.poll()[1];
                res[i] = points[index];
            }
        }
        return res;
    }

    private static int squareValue(int[] point) {
        return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
