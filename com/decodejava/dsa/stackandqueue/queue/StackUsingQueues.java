package com.decodejava.dsa.stackandqueue.queue;

import java.util.ArrayDeque;

public class StackUsingQueues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }

    static class MyStack {
        java.util.Queue<Integer> queue1;
        java.util.Queue<Integer> queue2;
        public MyStack() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        public void push(int x) {
            queue1.add(x);
        }

        public int pop() {
            if(queue1.isEmpty()) return -1;
            while(queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            int ele = queue1.poll();
            java.util.Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            return ele;
        }

        public int top() {
            while(queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            int ele = queue1.poll();
            queue2.add(ele);
            java.util.Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            return ele;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
