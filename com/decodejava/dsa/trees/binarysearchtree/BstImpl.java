package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.BinaryTree;
import com.decodejava.dsa.trees.impl.Node;

public class BstImpl {
    public static void main(String[] args) {
        Node<Integer> root = buildBST();
        BinaryTree.displayPrettySide(root, 0);
        System.out.println();
        root = delete(root, 4);
        BinaryTree.displayPrettySide(root, 0);
    }

    public static Node<Integer> buildBST() {
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
        return root;
    }

    public static Node<Integer> insert(Node<Integer> root, int data) {
        if (root == null) return new Node<>(data);

        if (data <= root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    public static Node<Integer> delete(Node<Integer> root, int data) {
        //case 1: Leaf Node
        //case 2: Node with 1 child
        //case 3: Node with 2 children

        //base case
        if (root == null) return null;

        //first find the node
        if(data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            //c1:
            if (root.left == null && root.right == null) { // leaf node
                return null;
            } else if (root.left == null) {// node with 1 child
                return root.right;
            } else if (root.right == null) {// node with 1 child
                return root.left;
            } else {//node with two children -> find the max in left subtree and replace node with it and delete replaced node in left subtree.
                Node<Integer> leftGreatest = findMaxLeft(root.left);
                root.data = leftGreatest.data;
                root.left = delete(root.left, leftGreatest.data);
            }
        }
        return root;
    }

    private static Node<Integer> findMaxLeft(Node<Integer> root) {
        if(root == null || root.right == null)
            return root;
        return findMaxLeft(root.right);
    }
}
