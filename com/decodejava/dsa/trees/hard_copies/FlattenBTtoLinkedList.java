package com.decodejava.dsa.trees.hard_copies;

import com.decodejava.dsa.trees.impl.Node;

import java.util.Stack;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBTtoLinkedList {
    public void flatten(Node<Integer> root) {
        if (root == null) return;
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<Integer> newRoot = stack.pop();
            if (newRoot.right != null) stack.push(newRoot.right);
            if (newRoot.left != null) stack.push(newRoot.left);

            newRoot.right = stack.isEmpty() ? null : stack.peek();
            newRoot.left = null;
        }
    }
}
