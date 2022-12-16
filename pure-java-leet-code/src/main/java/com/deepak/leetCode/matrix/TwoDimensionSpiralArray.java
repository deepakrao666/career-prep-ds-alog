package com.deepak.leetCode.matrix;

public class TwoDimensionSpiralArray {

    public static int[][] generateSpiralMatrix(int n) {
        int[] dc = new int[]{1, 0, -1, 0};
        int[] dr = new int[]{0, 1, 0, -1};
        int dir = 0, val = 0, r = 0, c = 0, limit = n * n;
        int[][] matrix = new int[n][n];
        while (val < limit) {
            matrix[r][c] = val;
            r += dr[dir];
            c += dc[dir];
            if (r < 0 || c < 0 || r >= n || c >= n || matrix[r][c] != 0) {
                r -= dr[dir];
                c -= dc[dir];
                dir = (dir + 1) % 4;
                r += dr[dir];
                c += dc[dir];
            }
            val++;
        }
        return matrix;
    }
}
