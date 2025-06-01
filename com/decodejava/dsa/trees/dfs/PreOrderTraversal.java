package com.decodejava.dsa.trees.dfs;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public List<Integer> preOrderTraversal(Node<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        preOrderTraversal(root, ans);
        return ans;
    }

    private void preOrderTraversal(Node<Integer> root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.data);
        preOrderTraversal(root.left, ans);
        preOrderTraversal(root.right, ans);
    }

    private void preOrderItr(Node<Integer> root, List<Integer> ans) {
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<Integer> newRoot = stack.pop();
            ans.add(newRoot.data);

            if (newRoot.right != null) stack.push(newRoot.right);
            if (newRoot.left != null) stack.push(newRoot.left);
        }
    }
}
