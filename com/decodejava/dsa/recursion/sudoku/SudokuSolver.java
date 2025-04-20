package com.decodejava.dsa.recursion.sudoku;

import java.util.Arrays;

//https://leetcode.com/problems/sudoku-solver/
//Time Complexity: 9^n^2 -> 9 times for all n^2 elements
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] sudoku =  {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(sudoku);
        for (char[] ch : sudoku) {
            System.out.println(Arrays.toString(ch));
        }
    }
    public static void solveSudoku(char[][] board) {
        solve(board, 0);
     }

    String ref = "com/decodejava/dsa/recursion/sudoku/resources/sudoku.png";
    public static boolean solve(char[][] board, int r) {
        for (int row = r; row < board.length; row++) { // start from r to eliminate redundant checks for already processed rows.
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(num, board, row, col)) {
                            board[row][col] = num;
                            //check for future
                            boolean isSolved = solve(board, row);
                            if(!isSolved) {// if not solved then do backtrack to check for next set of numbers.
                                board[row][col] = '.';
                            } else {// if solved then this number that we put is crt so don't backtrack just return true. Ans done
                               return true;
                            }
                        }
                    }
                    //If I reach here that means :
                    //I did not find any valid numbers from 1 to 9. so I could not solve. returning false so that my prev recursion fixes something.
                    return false;
                }
            }
        }
        //If I reach here that means I did not find any empty ie., '.' in the board. So solved.
        return true;
    }

    private static boolean isValid(int num, char[][] board, int row, int col) {
        //check row
        for (int c = 0; c < board.length; c++) {
            if (board[row][c] == num) return false;
        }
        //check column
        for (int r = 0; r < board.length; r++) {
            if(board[r][col] == num) return false;
        }
        //check grid
        int k = (int) Math.sqrt(board.length); // If its 9X9 matrix sqrt of 9 is 3.
        int startRow = row - (row % k); // remove the extra indexed by subtracting extra indexes.
        int startCol = col - (col % k); // remove the extra indexed by subtracting extra indexes.
        for (int r = startRow; r < startRow + k; r++) {
            for (int c = startCol; c < startCol + k; c++) {
                if (board[r][c] == num) return false;
            }
        }
        return true;
    }
}
