package com.deepak.leetCode.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    // todo : door dash

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int M;
    private static int N;

    public int shortestDistance(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        int[][] cost = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (grid[i][j] == 1) {

                    if (!updateCosts(grid, i, j, cost)) {
                        System.out.println("1. here");
                        return -1;
                    }
                }
            }
        }

        int shortestDist = Integer.MAX_VALUE;


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (grid[i][j] == 0) {
                    shortestDist = Math.min(shortestDist, cost[i][j]);
                } else {

                    if (grid[i][j] == 3) {
                        grid[i][j] = 0;
                    }
                }

            }
        }
        System.out.println("3. before end");

        for (int[] c : cost) {
            System.out.println(Arrays.toString(c));
        }

        System.out.println("X. Last");
        return shortestDist != Integer.MAX_VALUE ? shortestDist : -1;

    }

    private boolean updateCosts(int[][] grid, int x, int y, int[][] cost) {
        System.out.println("2. Update cost [" + x + "," + y + "]");
        boolean[][] visited = new boolean[M][N];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int distance = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0
                            || newCol < 0
                            || newRow >= M
                            || newCol >= N
                            || visited[newRow][newCol]
                            || grid[newRow][newCol] == 2) {
                        continue;
                    }

                    visited[newRow][newCol] = true;

                    if (grid[newRow][newCol] == 1) {
                        continue;
                    }

                    queue.offer(new int[]{newRow, newCol});
                    cost[newRow][newCol] += distance;
                }
            }

            distance++;
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    // mark all visited nodes as 3
                    if (grid[i][j] == 0) {
                        grid[i][j] = 3;
                    } else {
                        if (grid[i][j] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        for (int[] c : cost) {
            System.out.println(Arrays.toString(c));
        }

        return true;
    }
}
