package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;
import java.util.Stack;

//https://leetcode.com/problems/increasing-order-search-tree/
public class FlattenBTtoLinkedListII {
    public Node<Integer> increasingBST(Node<Integer> root) {
        Node<Integer> top = null;
        Stack<Node<Integer>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            Node<Integer> node = stack.pop();
            if (top == null)
                top = node;
            root = node.right;
            if (node.right == null) {
                node.right = stack.isEmpty() ? null : stack.peek();
            } else {
                Node<Integer> temp = node.right;
                while (temp.left != null) temp = temp.left;
                node.right = temp;
            }
            node.left = null;
        }
        return top;

    }
}
