package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.BinaryTree;
import com.decodejava.dsa.trees.impl.Node;

public class CeilOfNum {

    public static void main(String[] args) {
        Node<Integer> root = null;
        root = BstImpl.insert(root, 8);
        root = BstImpl.insert(root, 5);
        root = BstImpl.insert(root, 12);
        root = BstImpl.insert(root, 4);
        root = BstImpl.insert(root, 7);
        root = BstImpl.insert(root, 10);
        root = BstImpl.insert(root, 14);
        root = BstImpl.insert(root, 6);
        root = BstImpl.insert(root, 13);
        BinaryTree.displayPrettySide(root, 0);
        System.out.println();
        System.out.println(ceil(root, 11));
    }

    //smallest number greater than key
    public static Integer ceil(Node<Integer> root, int data) {
        if (root == null)
            return -1;
        int left = ceil(root.left, data);
        if (left != -1) return left;
        if (data <= root.data) return root.data;
        return ceil(root.right, data);
    }
}
