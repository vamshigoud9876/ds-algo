package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Stack;
//https://leetcode.com/problems/maximal-rectangle/
public class LargestAreaMaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    newMatrix[i][j] = i > 0 ? newMatrix[i-1][j] + 1 : 1;
                } else {
                    newMatrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < newMatrix.length; i++) {
            int[] arr = newMatrix[i];
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < arr.length; j++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[j]) {
                    int curInd = stack.pop();
                    int pse = stack.isEmpty() ? -1 : stack.peek();
                    int nse = j;
                    int area = arr[curInd] * (nse - pse - 1);
                    maxArea = Math.max(maxArea, area);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int curInd = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse = arr.length;
                int area = arr[curInd] * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
