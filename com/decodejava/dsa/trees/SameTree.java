package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/same-tree/
public class SameTree {
    public boolean isSameTree(Node<Integer> p, Node<Integer> q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null || p.data != q.data)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
