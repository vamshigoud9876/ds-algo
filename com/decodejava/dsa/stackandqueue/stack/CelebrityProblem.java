package com.decodejava.dsa.stackandqueue.stack;

//https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
public class CelebrityProblem {
    String img = "com/decodejava/dsa/stackandqueue/resources/celebrity_problem.png";

    public int celebrity(int[][] mat) {
        int[] iKnow = new int[mat.length];
        int[] knowMe = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (i != j && mat[i][j] == 1) {
                    iKnow[i]++;
                    knowMe[j]++;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (iKnow[i] == 0 && knowMe[i] == mat.length - 1) return i;
        }
        return -1;
    }
}
