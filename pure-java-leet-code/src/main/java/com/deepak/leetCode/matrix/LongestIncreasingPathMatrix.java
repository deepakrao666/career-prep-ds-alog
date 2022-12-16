package com.deepak.leetCode.matrix;

import java.util.Arrays;

public class LongestIncreasingPathMatrix {

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;

        int[][] cache = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        System.out.println(Arrays.deepToString(cache));

        return ans;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] cache) {
        if (cache[row][col] != 0) return cache[row][col];
        System.out.println(Arrays.deepToString(cache));

        for (int[] d : dirs) {
            int currRow = row + d[0];
            int currCol = col + d[1];

            if (0 <= currRow && currRow < m && 0 <= currCol && currCol < n && matrix[currRow][currCol] > matrix[row][col]) {
                cache[row][col] = Math.max(cache[row][col], dfs(matrix, currRow, currCol, cache));
            }
        }
        return ++cache[row][col];
    }
}
