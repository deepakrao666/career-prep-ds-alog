package com.deepak.leetCode.matrix;

public class ReshapeTheMatrix {


    // 2022. Convert 1D Array Into 2D Array
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n)
            return new int[1][1];

        int[][] res = new int[m][n];

        int rowCounter = 0;
        int colCounter = 0;


        for(int i: original){
            if(rowCounter <=m-1 && colCounter <=n-1){
                res[rowCounter][colCounter] = i;
            }
            if (colCounter == m - 1) {
                rowCounter++;
                colCounter = 0;
            } else
                colCounter++;

        }

        return res;
    }

    // 566. Reshape the Matrix
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int rowCounter = 0;
        int colCounter = 0;

        for (int[] row : mat) {
            for (int col : row) {
                res[rowCounter][colCounter] = col;
                if (colCounter == c - 1) {
                    rowCounter++;
                    colCounter = 0;
                } else
                    colCounter++;
            }
        }
        return res;
    }

}
