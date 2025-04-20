package com.decodejava.dsa.recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class AllPathsDownRight {
    public static void main(String[] args) {
        System.out.println(countTotalPaths(0, 0, 3));
        System.out.println(findTotalPaths(0, 0, 3, ""));
    }

    public static int countTotalPaths(int row, int col, int n) {
        if(row == n-1 || col == n-1) {
            return 1;
        }
        int leftCount = countTotalPaths(row + 1, col, n);
        int rightCount = countTotalPaths(row, col + 1, n);
        return leftCount + rightCount;
    }

    public static List<String> findTotalPaths(int row, int col, int n, String path) {
        List<String> list = new ArrayList<>();
        if(row == n-1 && col == n-1) {
            list.add(path);
            return list;
        }
        if (row != n-1) {
            list.addAll(findTotalPaths(row + 1, col, n, path + 'D'));
        }
        if (col != n-1) {
            list.addAll(findTotalPaths(row, col + 1, n, path + 'R'));
        }
        return list;
    }


}
