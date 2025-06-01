package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/
public class BSTIterator {
    Stack<Node<Integer>> stack;
    Node<Integer> root;

    public BSTIterator(Node<Integer> root) {
        stack = new Stack<>();
        this.root = root;
    }

    public int next() {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        int next = root.data;
        root = root.right;
        return next;
    }

    public boolean hasNext() {
        return root != null || !stack.isEmpty();
    }
}
