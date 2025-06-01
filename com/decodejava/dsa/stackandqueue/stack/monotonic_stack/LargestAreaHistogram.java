package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Stack;

public class LargestAreaHistogram {

    String img = "com/decodejava/dsa/stackandqueue/resources/histogram_optimal.png";
    //Time : O(N) Space : O(N)
    public int largestRectangleAreaOptimal(int[] heights) {
        //(nextSmallerElement - prevSmallerElement - 1) * height[i]
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                //evaluate for peek;
                int cur = stack.pop();
                //heights[i] --> pse
                //stack bottom ind is --> nse
                int nse = stack.isEmpty() ? n : stack.peek();
                int area = (nse - i - 1) * heights[cur];
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty() && heights[stack.peek()] > 0) {
            int cur = stack.pop();
            int nse = stack.isEmpty() ? n : stack.peek();
            int area = (nse - (-1) - 1) * heights[cur];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }


    String img2 = "com/decodejava/dsa/stackandqueue/resources/histogram_better.png";
    //Time: O(2n) Space O(N)
    public int largestRectangleAreaBetter(int[] heights) {
        //(nextSmallerElement - prevSmallerElement - 1) * height[i]
        int n = heights.length;
        int maxArea = 0;
        int[] nsi = new int[n];//next smaller index
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            boolean isNseFound = false;
            while(!stack.isEmpty()) {
                if (heights[stack.peek()] < heights[i]) {
                    nsi[i] = stack.peek();
                    isNseFound = true;
                    break;
                }
                stack.pop();
            }
            if (!isNseFound) {
                nsi[i] = n;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < n; i++) {
            int psi = -1;
            while(!stack.isEmpty()) {
                if (heights[stack.peek()] < heights[i]) {
                    psi = stack.peek();
                    break;
                }
                stack.pop();
            }
            stack.push(i);
            int area = (nsi[i] - psi - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }


    String img3 = "com/decodejava/dsa/stackandqueue/resources/histogram_brute.png";
    //Time: O(n^2)
    public int largestRectangleAreaBrute(int[] heights) {
        //(nextSmallerElement - prevSmallerElement - 1) * height[i]
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            //find PSE
            int prevSmallerIndex = -1;
            for (int left = i - 1; left >= 0; left--) {
                if (heights[left] < heights[i]) {
                    prevSmallerIndex = left;
                    break;
                }
            }

            //find NSE
            int nextSmallerIndex = n;
            for (int right = i + 1; right < n; right++) {
                if (heights[right] < heights[i]) {
                    nextSmallerIndex = right;
                    break;
                }
            }

            int area = (nextSmallerIndex - prevSmallerIndex - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
