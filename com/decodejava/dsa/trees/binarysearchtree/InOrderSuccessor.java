package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;

//https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1
public class InOrderSuccessor {

    public int inorderSuccessor(Node<Integer> root, Node<Integer> x) {
        if (root == null) return -1;
        int left = inorderSuccessor(root.left, x);
        if(left != -1)
            return left;
        if (x.data < root.data)
            return root.data;
        return inorderSuccessor(root.right, x);

    }
}
