package com.decodejava.dsa.recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class AllPathsObstacle {
    public static void main(String[] args) {
        int[][] obstacles = new int[][] {{0, 0, 0},
                                         {0, 1, 0},
                                         {0, 0, 0}};
        System.out.println(countTotalPaths(0, 0, 3, obstacles));
        List<String> totalPaths = findTotalPaths(0, 0, 3, "", obstacles);
        System.out.println("totalPaths " + totalPaths.size() +" : " + totalPaths);
    }

    public static int countTotalPaths(int row, int col, int n, int[][] obstacles) {
        //If I land at obstacle then just return back.
        if (obstacles[row][col] == 1)
            return 0;
        if(row == n-1 || col == n-1) {
            return 1;
        }
        int leftCount = countTotalPaths(row + 1, col, n, obstacles);
        int middleCount = countTotalPaths(row + 1, col + 1, n, obstacles);
        int rightCount = countTotalPaths(row, col + 1, n, obstacles);
        return leftCount + middleCount + rightCount;
    }

    public static List<String> findTotalPaths(int row, int col, int n, String path, int[][] obstacles) {
        //If I land at obstacle then just return back.
        List<String> list = new ArrayList<>();
        if (obstacles[row][col] == 1)
            return list;
        if(row == n-1 && col == n-1) {
            list.add(path);
            return list;
        }
        if (row != n-1) {
            list.addAll(findTotalPaths(row + 1, col, n, path + 'D', obstacles));
        }
        if (row != n-1 && col != n-1) {
            list.addAll(findTotalPaths(row + 1, col + 1, n, path + "d", obstacles));
        }
        if (col != n-1) {
            list.addAll(findTotalPaths(row, col + 1, n, path + 'R', obstacles));
        }
        return list;
    }
}
