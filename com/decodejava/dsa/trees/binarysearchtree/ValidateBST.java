package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;
import java.util.Stack;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
    Node<Integer> prev;
    public boolean isValidBST(Node<Integer> root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (prev != null && prev.data >= root.data) return false;
        prev = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public boolean isBSTItr(Node<Integer> root) {
        Stack<Node<Integer>> stack = new Stack<>();
        Node<Integer> node = root, prev = null;
        while (node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (prev != null && prev.data >= node.data) return false;
            prev = node;
            node = node.right;
        }
        return true;
    }
}
