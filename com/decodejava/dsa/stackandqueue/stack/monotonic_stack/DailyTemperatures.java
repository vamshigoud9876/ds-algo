package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = 0;
            while (!stack.isEmpty()) {
                if (nums[stack.peek()] > nums[i]) {
                    ans[i] = stack.peek() - i;
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
