package com.decodejava.dsa.stackandqueue.stack.implementations;

public class StackApp {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(5);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        customStack.pop();
        customStack.pop();
        customStack.display();
    }
}
