package com.decodejava.dsa.recursion.nknights;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int count = nKnights(board, 0, n, 0, 0);
        System.out.println(count);

    }
    public static int nKnights(boolean[][] board, int knightsPlaced, int n, int row, int col) {
        if (knightsPlaced == n) {
            displayBoard(board);
            return 1;
        } if (row == n) {// exhausted all the rows
            return 0;
        }
        if (col == n) {// finished my all cols, I have nothing towards right. So go down.
            return nKnights(board, knightsPlaced, n, row + 1, 0);
        }

        int count = 0;
        boolean canPlace = canPlace(board, row, col, n);
        if (canPlace) {
            board[row][col] = true;
            count = nKnights(board, knightsPlaced + 1, n, row, col + 1);
            board[row][col] = false;
        }
        count += nKnights(board, knightsPlaced, n, row, col + 1);
        return count;
    }

    private static boolean canPlace(boolean[][] board, int row, int col, int n) {
        //4conditions
        //Top left L
        if (isInRange(row - 2, col - 1, n)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isInRange(row - 1, col - 2, n)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        // Top right L ==> we are not comparing with bottoms because we are trying to come from top to bottom as no knight will be at bottom.
        if (isInRange(row - 2, col + 1, n)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isInRange(row - 1, col + 2, n)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInRange(int row, int col, int n) {
        return row < n && row >= 0 && col < n && col >= 0;
    }

    private static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean item : row) {
                if (item) System.out.print("K ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
