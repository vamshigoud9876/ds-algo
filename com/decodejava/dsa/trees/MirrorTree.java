package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/invert-binary-tree/
public class MirrorTree {
    public Node<Integer> invertTree(Node<Integer> root) {
        if (root == null) return null;

        Node<Integer> left = invertTree(root.left);
        Node<Integer> right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
