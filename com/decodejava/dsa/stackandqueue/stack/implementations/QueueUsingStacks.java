package com.decodejava.dsa.stackandqueue.stack.implementations;

import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String[] args) {
//         * Your MyQueue object will be instantiated and called as such:
            MyQueue obj = new QueueUsingStacks().new MyQueue();
            obj.push(1);
            int param_2 = obj.pop();
            int param_3 = obj.peek();
            boolean param_4 = obj.empty();
    }

   class MyQueue {
       private final Stack<Integer> stack1;
       private final Stack<Integer> stack2;

       public MyQueue() {
           stack1 = new java.util.Stack<>();
           stack2 = new java.util.Stack<>();
       }

       public void push(int x) {
           stack1.push(x);
       }

       public int pop() {
           while(!stack1.isEmpty()) {
               stack2.push(stack1.pop());
           }
           int ele = stack2.pop();
           while(!stack2.isEmpty()) {
               stack1.push(stack2.pop());
           }
           return ele;
       }

       public int peek() {
           while(!stack1.isEmpty()) {
               stack2.push(stack1.pop());
           }
           int ele = stack2.peek();
           while(!stack2.isEmpty()) {
               stack1.push(stack2.pop());
           }
           return ele;
       }

       public boolean empty() {
           return stack1.isEmpty();
       }
   }
}
