package com.decodejava.dsa.stackandqueue.stack;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class AsteriodCollision {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -a[i]) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(a[i]);
            } else
                stack.push(a[i]);
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
