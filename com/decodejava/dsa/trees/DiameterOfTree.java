package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfTree {
    public int diameterOfBinaryTree(Node<Integer> root) {
        return helper(root)[1];
    }

    public int[] helper(Node<Integer> root) {
        if(root == null) return new int[]{0, 0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        left[1] = Math.max(left[0] + right[0], Math.max(left[1], right[1]));//diameter
        left[0] = Math.max(left[0], right[0]) + 1;
        return left;
    }
}
