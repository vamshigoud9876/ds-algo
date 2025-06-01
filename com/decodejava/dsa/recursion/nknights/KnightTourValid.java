package com.decodejava.dsa.recursion.nknights;

//https://leetcode.com/problems/check-knight-tour-configuration/
public class KnightTourValid {
    public static void main(String[] args) {
        int[][] grid = {{0,11,16,5,20},
                        {17,4,19,10,15},
                        {12,1,8,21,6},
                        {3,18,23,14,9},
                        {24,13,2,7,22}};

        int[][] grid1 = {{24,11,22,17, 4},
                         {21,16, 5, 12,9},
                         {6, 23, 10,3,18},
                         {15,20, 1, 8,13},
                         {0, 7, 14,19,2}};
        System.out.println(new KnightTourValid().checkValidGrid(grid1));
    }
    public boolean checkValidGrid(int[][] grid) {
        return gridHelper(grid, 0, 0, grid.length);
    }

    public boolean gridHelper(int[][] grid, int row, int col, int n) {
        if(grid[0][0] != 0) return false;
        int[] nextMove = findNextMove(grid, row, col, n);
        if(grid[row][col] == (n*n)-1) return true;
        if(nextMove[0] == -1 && nextMove[1] == -1) {
            return false;
        }
        return gridHelper(grid, nextMove[0], nextMove[1], n);

    }
    public int[] findNextMove(int[][] grid, int row, int col, int n) {
        //top left
        int nextNum = grid[row][col] + 1;
        if(isValidRowCol(row - 1, col - 2, n)) {
            if(grid[row - 1][col - 2] == nextNum)
                return new int[]{row - 1, col - 2};
        }
        if(isValidRowCol(row - 2, col - 1, n)) {
            if(grid[row - 2][col - 1] == nextNum)
                return new int[]{row - 2, col - 1};
        }
        //top right
        if(isValidRowCol(row - 1, col + 2, n)) {
            if(grid[row - 1][col + 2] == nextNum)
                return new int[]{row - 1, col + 2};
        }
        if(isValidRowCol(row - 2, col + 1, n)) {
            if(grid[row - 2][col + 1] == nextNum)
                return new int[]{row - 2, col + 1};
        }
        // bottom left
        if(isValidRowCol(row + 1, col - 2, n)) {
            if(grid[row + 1][col - 2] == nextNum)
                return new int[]{row + 1, col - 2};
        }
        if(isValidRowCol(row + 2, col - 1, n)) {
            if(grid[row + 2][col - 1] == nextNum)
                return new int[]{row + 2, col - 1};
        }
        // bottom right
        if(isValidRowCol(row + 1, col + 2, n)) {
            if(grid[row + 1][col + 2] == nextNum)
                return new int[]{row + 1, col + 2};
        }
        if(isValidRowCol(row + 2, col + 1, n)) {
            if(grid[row + 2][col + 1] == nextNum)
                return new int[]{row + 2, col + 1};
        }
        return new int[]{-1, -1};
    }

    private boolean isValidRowCol(int row, int col, int n) {
        return row >= 0 && row < n && col >=0 && col < n;
    }
}
