package com.decodejava.dsa.trees.sum;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeaf {

    public int sumNumbers(Node<Integer> root) {
        return helper(root, 0);
    }
    public int helper(Node<Integer> root, int n) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return (n * 10) + root.data;
        }

        n *= 10;
        int left = helper(root.left, n + root.data);
        int right = helper(root.right, n + root.data);
        return left + right;

    }
}
