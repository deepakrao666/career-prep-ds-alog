package com.deepak.leetCode.matrix;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (target <= row[row.length - 1] && target >= row[0]) {
                for (int colValue : row) {
                    if(colValue == target)
                        return true;
                }
            }
        }
        return false;
    }
}
