package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LcaBST {
    public Node<Integer> lowestCommonAncestor(Node<Integer> root, Node<Integer> p, Node<Integer> q) {
        if (root == null) return null;

        if (root.data > p.data && root.data > q.data)
            return lowestCommonAncestor(root.left, p, q);
        if (root.data < p.data && root.data < q.data)
            return lowestCommonAncestor(root.right, p, q);

        return root;// if root.data == p or q / if p < root.data > q / if q < root.data > p ,then return root.
    }
}
