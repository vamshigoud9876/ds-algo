package com.decodejava.dsa.revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueensI {
    public static void main(String[] args) {
        System.out.println(new NQueensI().solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[] colVis = new boolean[n];
        boolean[] leftDiagVis = new boolean[2 * n - 1];
        boolean[] rightDiagVis = new boolean[2 * n - 1];
        List<List<String>> allWays = new ArrayList<>();
        findWays(n, colVis, leftDiagVis, rightDiagVis, 0, new ArrayList<>(), allWays);
        return allWays;
    }

    private void findWays(int n, boolean[] colVis, boolean[] leftDiagVis, boolean[] rightDiagVis, int row, List<String> finishedRows, List<List<String>> finalAns) {
        if (row == n) {
            finalAns.add(new ArrayList<>(finishedRows));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, colVis, leftDiagVis, rightDiagVis)) {
                colVis[col] = true;
                rightDiagVis[row + col] = true;
                leftDiagVis[col + ((n - 1) - row)] = true;
                StringBuilder positionBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (col == i) positionBuilder.append("Q");
                    else positionBuilder.append(".");
                }
                finishedRows.add(positionBuilder.toString());
                findWays(n, colVis, leftDiagVis, rightDiagVis, row + 1, finishedRows, finalAns);
                finishedRows.remove(finishedRows.size() - 1);
                colVis[col] = false;
                rightDiagVis[row + col] = false;
                leftDiagVis[col + ((n - 1) - row)] = false;
            }
        }
    }

    private boolean isSafe(int row, int col, boolean[] colVis, boolean[] leftDiagVis, boolean[] rightDiagVis) {
        //column check
        return !colVis[col] && !leftDiagVis[col + ((colVis.length - 1) - row)] && !rightDiagVis[col + row];
    }
}
