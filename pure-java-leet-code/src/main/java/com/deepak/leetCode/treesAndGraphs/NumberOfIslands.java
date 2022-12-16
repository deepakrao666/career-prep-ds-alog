package com.deepak.leetCode.treesAndGraphs;

import java.util.Arrays;
import java.util.List;

public class NumberOfIslands {
    private static final List<int[]> directions = Arrays.asList(
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0}
    );
    private static int rows;
    private static int cols;
    private static final char land = '1';
    private static final char water = '0';

    public int numIslands(char[][] grid) {
        System.out.println(land);
        System.out.println(water);
        int res = 0;
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == land) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int currentRow, int currentCol) {

        grid[currentRow][currentCol] = water;
        directions.forEach(dir -> {
            int toRow = currentRow + dir[0];
            int toCol = currentCol + dir[1];

            if (toRow > 0
                    && toCol > 0
                    && toRow < rows
                    && toCol < cols
                    && grid[toRow][toCol] != '0') {
                dfs(grid, toRow, toCol);
            }
        });
    }
}
