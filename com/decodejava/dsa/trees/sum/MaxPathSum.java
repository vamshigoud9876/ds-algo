package com.decodejava.dsa.trees.sum;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(Node<Integer> root) {
        helper(root);
        return max;
    }

    public int helper(Node<Integer> root) {
        if(root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        max = Math.max(root.data + left + right, max);
        return Math.max(left , right) + root.data;
    }
}
