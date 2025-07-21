package com.decodejava.dsa.trees.hard_copies;

import com.decodejava.dsa.trees.impl.Node;

import java.util.Stack;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// 1. Use Boundary limits in the recursion to solve this problem.
// 2. Use Stack to solve this.
public class BSTFromPreorder {
    public Node<Integer> bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] nextGreater = new int[n];
        buildNextGreater(preorder, nextGreater, n);
        return buildBST(preorder, 0, n - 1, nextGreater);
    }

    private Node<Integer> buildBST(int[] preorder, int start, int end, int[] nge) {
        if (start > end) return null;

        Node<Integer> root = new Node<Integer>(preorder[start]);
        root.left = buildBST(preorder, start + 1, nge[start] - 1, nge);
        root.right = buildBST(preorder, nge[start], end, nge);
        return root;
    }

    private void buildNextGreater(int[] preorder, int[] nextGreater, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            nextGreater[i] = n;
            while (!stack.isEmpty()) {
                if (preorder[stack.peek()] > preorder[i]) {
                    nextGreater[i] = stack.peek();
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
    }
}
