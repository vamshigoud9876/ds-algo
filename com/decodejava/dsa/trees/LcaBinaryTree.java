package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LcaBinaryTree {
    public Node<Integer> lowestCommonAncestor(Node<Integer> root, Node<Integer> p, Node<Integer> q) {
        if (root == null) return null;

        Node<Integer> left = lowestCommonAncestor(root.left, p, q);
        Node<Integer> right = lowestCommonAncestor(root.right, p, q);
        if (root == q || root == p) return root;
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
