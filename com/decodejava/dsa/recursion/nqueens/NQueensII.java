package com.decodejava.dsa.recursion.nqueens;

//https://leetcode.com/problems/n-queens-ii/
public class NQueensII {
    public int totalNQueens(int n) {
        boolean[] leftDiag = new boolean[2 * n -1];
        boolean[] rightDiag = new boolean[2 * n -1];
        boolean[] top = new boolean[n];
        return countPaths(leftDiag, rightDiag, top, 0, n);
    }
    public int countPaths(boolean[] leftDiag, boolean[] rightDiag, boolean[] top, int row, int n) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for(int col = 0; col < n; col++) {
            boolean canPlace = !(leftDiag[n-1-row + col] || rightDiag[row + col] || top[col]);
            if(canPlace) {
                leftDiag[n-1-row + col] = rightDiag[row + col] = top[col] = true;
                count += countPaths(leftDiag, rightDiag, top, row + 1, n);
                leftDiag[n-1-row + col] = rightDiag[row + col] = top[col] = false;
            }
        }
        return count;
    }
}