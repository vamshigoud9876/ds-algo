package com.decodejava.dsa.stackandqueue.stack.implementations;

public class CustomStack {
    private final int[] arr;
    private int top;

    public CustomStack(int size) {
        top = -1;
        arr = new int[size];
    }

    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow");
        }
        arr[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }
        return arr[top--];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == arr.length - 1;
    }

    public void display() {
        for (int temp = top; temp >= 0; temp--) {
            System.out.println(arr[temp]);
        }
    }

}
