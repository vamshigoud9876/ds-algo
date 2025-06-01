package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-ranges/
public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] arr) {

        //same as SumOfSubarrayMinimums
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        long largest = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            while(!stack.isEmpty()) {
                if (arr[stack.peek()] < arr[i]) {
                    int cur = stack.pop();
                    int pse = i;
                    int nse = stack.isEmpty() ? n : stack.peek();
                    largest += ((long) cur - pse) * ((long) nse - cur) * (long) arr[cur];
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            int pse = -1;
            int nse = stack.isEmpty() ? n : stack.peek();
            largest += ((long) cur - pse) * ((long) nse - cur) * (long) arr[cur];
        }

        long smallest = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            while(!stack.isEmpty()) {
                if (arr[stack.peek()] > arr[i]) {
                    int cur = stack.pop();
                    int pse = i;
                    int nse = stack.isEmpty() ? n : stack.peek();
                    smallest += ((long) cur - pse) * ((long) nse - cur) * (long) arr[cur];
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            int pse = -1;
            int nse = stack.isEmpty() ? n : stack.peek();
            smallest += ((long) cur - pse) * ((long) nse - cur) * (long) arr[cur];
        }
        return largest - smallest;
    }
}
