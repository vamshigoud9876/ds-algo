package com.decodejava.dsa.trees.hard_copies;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {
    Node<Integer> node1;
    Node<Integer> node2;
    Node<Integer> prev;
    public void recoverTree(Node<Integer> root) {
        helper(root);
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public void helper(Node<Integer> root) {
        if (root == null) return;

        helper(root.left);
        if(prev != null && node1 == null && prev.data > root.data) {
            node1 = prev;
        }
        if (prev != null && node1 != null && prev.data > root.data) {
            node2 = root;
        }
        prev = root;

        helper(root.right);

    }
}
