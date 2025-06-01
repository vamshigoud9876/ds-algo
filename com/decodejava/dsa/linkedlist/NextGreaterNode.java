package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

import java.util.Stack;

//https://leetcode.com/problems/next-greater-node-in-linked-list
public class NextGreaterNode {
    //Monotonic stack
    public int[] nextLargerNodes(Node head) {
        int[] ans = new int[findLen(head)];
        helper(head, 0, new Stack<>(), ans);
        return ans;
    }
    public void helper(Node head, int i, Stack<Integer> stack, int[] ans) {
        if (head == null) {
            return;
        }
        helper(head.next, i+1, stack, ans);
        while(!stack.isEmpty()) {
            if (stack.peek() > head.data) {
                ans[i] = stack.peek();
                break;
            }
            stack.pop();
        }
        stack.push(head.data);
    }
    public int findLen(Node head) {
        if(head == null) {
            return 0;
        }
        return findLen(head.next) + 1;
    }
}
