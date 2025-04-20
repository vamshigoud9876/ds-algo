package com.decodejava.dsa.recursion.nqueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(placeNQueens(n, board, new ArrayList<>(), 0));
    }

    public static List<List<Integer>> placeNQueens(int n, boolean[][] board, List<Integer> ans, int row) {
        List<List<Integer>> finalAns = new ArrayList<>();
        if (row == n) {
            List<Integer> temp = new ArrayList<>(ans);
            finalAns.add(temp);
            return finalAns;
        }
        for (int col = 0; col < n; col++) {
            boolean canPlace = true;
            //check up
            for (int r = row; r >= 0; r--) {
                if(board[r][col]) {
                    canPlace = false;
                    break;
                }
            }
            //check left diagonal
            if (canPlace) {
                int r = row, c = col;
                while(r != -1 && c != -1) {
                    if(board[r][c]) {
                        canPlace = false;
                        break;
                    }
                    r--; c--;
                }
            }

            //check right diagonal
            if (canPlace) {
                int r = row, c = col;
                while(r != -1 && c != n) {
                    if(board[r][c]) {
                        canPlace = false;
                        break;
                    }
                    r--; c++;
                }
            }

            if (canPlace) {
                board[row][col] = true;
                ans.add(col+1);
                finalAns.addAll(placeNQueens(n, board, ans, row + 1));
                ans.remove(ans.size() - 1);//backtrack
                board[row][col] = false;//backtrack
            }
        }
        return finalAns;
    }
}
