package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchBST {
    public Node<Integer> searchBST(Node<Integer> root, int data) {
        if (root == null) return null;
        if(data < root.data) {
            return searchBST(root.left, data);
        } else if (data > root.data) {
            return searchBST(root.right, data);
        } else {
            return root;
        }
    }
}
