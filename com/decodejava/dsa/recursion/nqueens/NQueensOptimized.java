package com.decodejava.dsa.recursion.nqueens;

import java.util.ArrayList;
import java.util.List;

public class NQueensOptimized {
    public static void main(String[] args) {
        int n = 4;
        boolean[] cols = new boolean[n];
        boolean[] leftDiag = new boolean[2 * n - 1];
        boolean[] rightDiag = new boolean[2 * n - 1];
        List<List<Integer>> solved = new ArrayList<>();
        solveNQueens(cols, leftDiag, rightDiag, 0, new ArrayList<>(), solved, n);
        System.out.println(solved);

    }
    String imgRef = "com/decodejava/dsa/recursion/resources/nqueens_opt.png";
    public static void solveNQueens(boolean[] cols, boolean[] leftDiag, boolean[] rightDiag, int row, List<Integer> ans, List<List<Integer>> allAns, int n) {
        if (row == n) {
            List<Integer> tempAns = new ArrayList<>(ans);
            allAns.add(tempAns);
            return;
        }
        for (int col = 0; col < n; col++) {
            boolean canPlace = !(cols[col] || leftDiag[(n-1-row)+col] || rightDiag[row+col]);
            if (canPlace) {
                cols[col] = leftDiag[(n-1-row) + col] = rightDiag[row+col] = true;// I have place it here.
                ans.add(col+1);
                solveNQueens(cols, leftDiag, rightDiag, row + 1, ans, allAns, n);
                ans.remove(ans.size() - 1);
                cols[col] = leftDiag[(n-1-row)+col] = rightDiag[row+col] = false;// backtrack
            }
        }
    }
}
