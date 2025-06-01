package com.decodejava.dsa.stackandqueue.stack.implementations;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinStack {

    private final Stack<Pair<Integer, Integer>> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty())
            stack.push(new Pair<>(val, val));
         else
            stack.push(new Pair<>(val, Math.min(val, stack.peek().min)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    static class Pair<T1, T2> {
        T1 val;
        T2 min;

        public Pair(T1 val, T2 min) {
            this.val = val;
            this.min = min;
        }
    }
}
