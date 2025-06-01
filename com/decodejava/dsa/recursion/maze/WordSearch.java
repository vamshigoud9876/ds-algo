package com.decodejava.dsa.recursion.maze;

//https://leetcode.com/problems/word-search/
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new WordSearch().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return false;
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    vis[row][col] = true;
                    if (searchHelper(board, vis, row, col, word, 1)) return true;
                    vis[row][col] = false;
                }
            }
        }
        return false;
    }

    public boolean searchHelper(char[][] board, boolean[][] vis, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        char letter = word.charAt(index);

        if (row > 0 && !vis[row - 1][col] && board[row - 1][col] == letter) {
            vis[row - 1][col] = true;
            if (searchHelper(board, vis, row - 1, col, word, index + 1)) return true;
            vis[row - 1][col] = false;
        }

        if (col > 0 && !vis[row][col - 1] && board[row][col - 1] == letter) {
            vis[row][col - 1] = true;
            if(searchHelper(board, vis, row, col - 1, word, index + 1)) return true;
            vis[row][col - 1] = false;
        }

        if (row < board.length - 1 && !vis[row + 1][col] && board[row + 1][col] == letter) {
            vis[row + 1][col] = true;
            if(searchHelper(board, vis, row + 1, col, word, index + 1)) return true;
            vis[row + 1][col] = false;
        }

        if (col < board[0].length - 1  && !vis[row][col + 1] && board[row][col + 1] == letter) {
            vis[row][col + 1] = true;
            if(searchHelper(board, vis, row, col + 1, word, index + 1)) return true;
            vis[row][col + 1] = false;

        }
        return false;
    }


}
