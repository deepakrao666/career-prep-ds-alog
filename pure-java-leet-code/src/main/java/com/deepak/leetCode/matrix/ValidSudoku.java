package com.deepak.leetCode.matrix;

public class ValidSudoku {
    public static void main(String[] args) {

        char[][] board = new char[][]
                {
                        {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                        {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
                };

        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }

    public static boolean isValidSudoku(char[][] board) {
        // todo : this is worng
        int[][] dp = new int[9][9];

        for (int[] row : dp) {
            for (int col : row) {
                col = 0;
            }
        }
        // -1 invalid
        // 0 not visited
        // 1 visited valid

        for (int row = 0; row < 9; row++) {


            for (int col = 0; col < 9; col++) {

                char current = board[row][col];

                if (current == '.') {
                    continue;
                }

                // search column
                for (int i = 0; i < 9; i++) {
                    if (i == col || dp[row][i] == 1) {
                        continue;
                    }

                    if (dp[row][i] == -1)
                        return false;

                    if (board[row][i] == current) {
                        dp[row][i] = -1;
                        return false;
                    } else {
                        dp[row][i] = 1;
                    }
                }

                // search row
                for (int i = 0; i < 9; i++) {
                    if (i == col || dp[i][col] == 1) {
                        continue;
                    }

                    if (dp[i][col] == -1)
                        return false;

                    if (board[i][col] == current) {
                        dp[i][col] = -1;
                        return false;
                    } else {
                        dp[i][col] = 1;
                    }
                }
            }
        }

        // validate 3x3 contains

        return true;
    }
}
