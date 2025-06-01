package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.BinaryTree;
import com.decodejava.dsa.trees.impl.Node;

public class FloorOfNum {

    public static void main(String[] args) {
        Node<Integer> root = BstImpl.buildBST();
        BinaryTree.displayPrettySide(root, 0);
        System.out.println();
        System.out.println(floor(root, 11));
    }

    //greatest number smaller than key
    public static Integer floor(Node<Integer> root, int data) {
        if (root == null) return -1;
        if (root.data > data) {
            return floor(root.left, data);
        } else {
            int prev = floor(root.right, data);
            return (prev != -1) ? prev : root.data;
        }
    }
}
