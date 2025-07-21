package com.decodejava.dsa.trees.sum;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/sum-of-left-leaves/
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(Node<Integer> root) {
        return sumHelper(root, false);
    }

    public int sumHelper(Node<Integer> root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) {
            return root.data;
        }
        return sumHelper(root.left, true) + sumHelper(root.right, false);
    }
}
