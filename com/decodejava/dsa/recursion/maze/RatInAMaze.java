package com.decodejava.dsa.recursion.maze;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1&selectedLang=python3
public class RatInAMaze {

    public static void main(String[] args) {
        List<List<Integer>> input = buildObstacles();
        System.out.println(new RatInAMaze().findPath(input));
    }

    public ArrayList<String> findPath(List<List<Integer>> mat) {
        boolean[][] visited = new boolean[mat.size()][mat.get(0).size()];
        ArrayList<String> ans = new ArrayList<>();
        getRatPath(visited, 0, 0, mat, ans, new StringBuilder());
        return ans;
    }
    public void getRatPath(boolean[][] vis, int row, int col, List<List<Integer>> obs, List<String> ans, StringBuilder path) {
        if(obs.get(row).get(col) == 0) return;// If there is an obstacle then go back.
        if (row == obs.size() - 1 && col == obs.get(0).size() - 1) {
            ans.add(path.toString());
            return;
        }

        //mark visited
        vis[row][col] = true;

        //up
        if(row != 0 && !vis[row - 1][col]) {
            getRatPath(vis, row - 1, col, obs, ans, path.append("U"));
            path.deleteCharAt(path.length() - 1);//backtrack
        }

        //right
        if(col != obs.get(0).size() - 1 && !vis[row][col + 1]) {
            getRatPath(vis, row, col + 1, obs, ans, path.append("R"));
            path.deleteCharAt(path.length() - 1);//backtrack
        }

        //down
        if(row != obs.size() - 1 && !vis[row + 1][col]) {
            getRatPath(vis, row + 1, col, obs, ans, path.append("D"));
            path.deleteCharAt(path.length() - 1);//backtrack
        }

        //left
        if(col != 0 && !vis[row][col - 1]) {
            getRatPath(vis, row, col - 1, obs, ans, path.append("L"));
            path.deleteCharAt(path.length() - 1);//backtrack
        }
        vis[row][col] = false;//backtrack
    }


    private static List<List<Integer>> buildObstacles() {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<Integer> r3 = new ArrayList<>();
        List<Integer> r4 = new ArrayList<>();
        r1.add(1);r1.add(0);r1.add(0);r1.add(0);
        r2.add(1);r2.add(1);r2.add(0);r2.add(1);
        r3.add(1);r3.add(1);r3.add(0);r3.add(0);
        r4.add(0);r4.add(1);r4.add(1);r4.add(1);
        input.add(r1);
        input.add(r2);
        input.add(r3);
        input.add(r4);
        return input;
    }
}
