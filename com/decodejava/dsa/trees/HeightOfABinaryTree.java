package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class HeightOfABinaryTree {
    public int height(Node<Integer> root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
