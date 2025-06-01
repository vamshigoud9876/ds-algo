package com.decodejava.dsa.trees.dfs;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postOrderTraversal(Node<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        postOrderTraversal(root, ans);
        return ans;
    }

    private void postOrderTraversal(Node<Integer> root, List<Integer> ans) {
        if (root == null) return;
        postOrderTraversal(root.left, ans);
        postOrderTraversal(root.right, ans);
        ans.add(root.data);
    }

//    O(2N)
    private void postOrderItr2Stacks(Node<Integer> root, List<Integer> ans) {
        if (root == null) return;
        Stack<Node<Integer>> stack1 = new Stack<>();
        Stack<Node<Integer>> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node<Integer> newRoot = stack1.pop();
            stack2.push(newRoot);

            if (newRoot.left != null) stack1.push(newRoot.left);
            if (newRoot.right != null) stack1.push(newRoot.right);
        }
        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().data);
        }
    }

//    O(N)
    private void postOrderItr1Stack(Node<Integer> root, List<Integer> ans) {
        if (root == null) return;
        Stack<Node<Integer>> stack = new Stack<>();
        Node<Integer> lastVisited = null, cur = root;
        while (cur != null || !stack.isEmpty()) {
            //go to extreme left
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //check if right exists and unvisited
            root = stack.peek();
            if (root.right != null && lastVisited != root.right) {
                cur = root.right;
            } else {
                //left and right are visited or both are null
                root = stack.pop();
                ans.add(root.data);
                lastVisited = root;
            }
        }
    }
}
