package com.decodejava.dsa.revision.recursion;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSolver(board, 0, 0);
    }

    private boolean solveSolver(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }
        if (col == board.length)
            return solveSolver(board, row + 1, 0);
        if (board[row][col] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if (isValid(board, i, row, col)) {
                    board[row][col] = i;
                    boolean isSolved;
                    isSolved = solveSolver(board, row, col + 1);
                    if (isSolved)
                        return true;
                    board[row][col] = '.';
                }
            }
            return false;
        }
        return true;
    }

    private boolean isValid(char[][] board, char num, int row, int col) {
        //check row
        for (int colNum = 0; colNum < board.length; colNum++) {
            if (board[row][colNum] == num) return false;
        }

        //check col
        for (int rowNum = 0; rowNum < board.length; rowNum++) {
            if (board[rowNum][col] == num) return false;
        }

        int rowIndex = row - (row % 3);
        int colIndex = col - (col % 3);

        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = colIndex; j < colIndex + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
