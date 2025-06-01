package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumOfSubarrayMinimums {
    String img = "com/decodejava/dsa/stackandqueue/resources/sum_of_subarrays_min.png";
    public int sumSubarrayMins(int[] arr) {
//        find nse
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            nse[i] = n;
            while(!stack.isEmpty()) {
                if (arr[stack.peek()] < arr[i]) {
                    nse[i] = stack.peek();
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }

        //along pse calculate min sums
        stack.clear();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int pse = -1;
            while(!stack.isEmpty()) {
                if (arr[stack.peek()] < arr[i]) {
                    pse = stack.peek();
                    break;
                }
                stack.pop();
            }
            ans += (i - pse) * (nse[i] - i) * arr[i];
            stack.push(i);
        }
        return ans;
    }

    public int sumSubarrayMinsOptimal(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        long ans = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            while(!stack.isEmpty()) {
                if (arr[stack.peek()] > arr[i]) {
                    int cur = stack.pop();
                    int pse = i;
                    int nse = stack.isEmpty() ? n : stack.peek();
                    ans += ((long) cur - pse) * ((long) nse - cur) * (long) arr[cur];
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            if (arr[stack.peek()] > 0) {
                int cur = stack.pop();
                int pse = -1;
                int nse = stack.isEmpty() ? n : stack.peek();
                ans += ((long) cur - pse) * ((long) nse - cur) * (long) arr[cur];
            } else {
                break;
            }
        }
        return (int) (ans % 1000000007L);
    }
}
