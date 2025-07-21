package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
public class MinAbsDiffBST {
    Node<Integer> prev;
    public int getMinimumDifference(Node<Integer> root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = getMinimumDifference(root.left);
        int diff = Integer.MAX_VALUE;
        if (prev != null) {
            diff = Math.abs(prev.data - root.data);
        }
        prev = root;
        int right = getMinimumDifference(root.right);
        return Math.min(right, Math.min(diff, left));
    }
}
