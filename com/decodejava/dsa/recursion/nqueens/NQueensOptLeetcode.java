package com.decodejava.dsa.recursion.nqueens;

import java.util.ArrayList;
import java.util.List;

public class NQueensOptLeetcode {
    public static void main(String[] args) {
        int n = 4;
        boolean[] cols = new boolean[n];
        boolean[] leftDiag = new boolean[2 * n - 1];
        boolean[] rightDiag = new boolean[2 * n - 1];
        List<List<String>> solved = new ArrayList<>();
        solveNQueens(cols, leftDiag, rightDiag, 0, new ArrayList<>(), solved, n);
        System.out.println(solved);

    }
    public static void solveNQueens(boolean[] cols, boolean[] leftDiag, boolean[] rightDiag, int row, List<Integer> ans, List<List<String>> allAns, int n) {
        if (row == n) {
            List<String> formattedAns = new ArrayList<>();
            for (int col : ans) {
                StringBuilder formatedString = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    formatedString.append(".");
                }
                formatedString.replace(col, col+1, "Q");
                formattedAns.add(formatedString.toString());
            }
            allAns.add(formattedAns);
            return;
        }
        for (int col = 0; col < n; col++) {
            boolean canPlace = !(cols[col] || leftDiag[(n-1-row)+col] || rightDiag[row+col]);
            if (canPlace) {
                cols[col] = leftDiag[(n-1-row)+col] = rightDiag[row+col] = true;// I have place it here.
                ans.add(col);
                solveNQueens(cols, leftDiag, rightDiag, row + 1, ans, allAns, n);
                ans.remove(ans.size() - 1);
                cols[col] = leftDiag[(n-1-row)+col] = rightDiag[row+col] = false;// backtrack
            }
        }
    }
}
