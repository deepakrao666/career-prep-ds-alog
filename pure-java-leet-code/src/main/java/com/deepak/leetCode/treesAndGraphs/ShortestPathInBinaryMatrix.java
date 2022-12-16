package com.deepak.leetCode.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    private static final int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0)
            return -1;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();

            int row = poll[0];
            int col = poll[1];
            int distance = grid[row][col];

            if (row == m - 1 && col == n - 1)
                return distance;


            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighborRow = neighbour[0];
                int neighborCol = neighbour[1];
                queue.add(new int[]{neighborRow, neighborCol});
                grid[neighborRow][neighborCol] = distance + 1;
            }
        }

        return -1;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int[] ints : dir) {
            int newRow = row + ints[0];
            int newCol = col + ints[1];

            if (newRow < 0
                    || newRow >= grid.length
                    || newCol < 0
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }

            neighbours.add(new int[]{newRow, newCol});
        }

        return neighbours;
    }
}
