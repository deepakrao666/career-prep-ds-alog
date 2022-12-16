package com.deepak.leetCode.treesAndGraphs;

public class SudokuSolver {

    // todo : doordash

    static int counter = 0;

    public void solveSudoku(char[][] board) {
        solve(board);
        System.out.println("solve counter = " + counter);
    }

    private boolean solve(char[][] board) {
        counter++;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col] == '.') {
                    for (char guessChar = '1'; guessChar <= '9'; guessChar++) {
                        if (isBoardValid(board, row, col, guessChar)) {
                            board[row][col] = guessChar;

                            boolean checkIfGuessCharIsValid = solve(board);

                            // continue
                            if (checkIfGuessCharIsValid)
                                return true;
                                // backtrack
                            else
                                board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBoardValid(char[][] board, int row, int col, char guessChar) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == guessChar)
                return false;

            if (board[i][col] == guessChar)
                return false;

            // check between subgrid;
            int rowMargin = 3 * (row / 3) + i / 3;
            int colMargin = 3 * (col / 3) + i % 3;

            if (counter == 1 || counter == 2) {
                System.out.println("counter = "+counter + ", rowMargin = " + rowMargin + ", colMargin = " + colMargin);
            }

            if (board[rowMargin][colMargin] == guessChar)
                return false;
        }

        return true;
    }


}
