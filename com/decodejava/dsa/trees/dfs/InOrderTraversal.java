package com.decodejava.dsa.trees.dfs;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inOrderTraversal(Node<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        inOrderTraversal(root, ans);
        return ans;
    }

    private void inOrderTraversal(Node<Integer> root, List<Integer> ans) {
        if (root == null) return;
        inOrderTraversal(root.left, ans);
        ans.add(root.data);
        inOrderTraversal(root.right, ans);
    }

    private void inOrderItr(Node<Integer> root, List<Integer> ans) {
        Stack<Node<Integer>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {//go to extreme left
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //left done so, take root and print and cur(root) becomes root.right
            //since we don't want to go left to root again since we already went there.
            root = stack.pop();
            ans.add(root.data);
            root = root.right;
        }
    }

}
