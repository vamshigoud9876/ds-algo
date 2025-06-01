package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
public class InOrderSuccessorPredecessor {
    Node<Integer> predecessor;
    public ArrayList<Node<Integer>> findPreSuc(Node<Integer> root, int key) {
        ArrayList<Node<Integer>> ans = new ArrayList<>();
        Node<Integer> suc = inorderSuccessor(root, key);
        ans.add(predecessor);
        ans.add(suc);
        return ans;
    }

    public Node<Integer> inorderSuccessor(Node<Integer> root, int x) {
        if (root == null) return null;

        Node<Integer> left = inorderSuccessor(root.left, x);
        if (left != null)
            return left;
        if (root.data < x)
            predecessor = root;
        else if(root.data > x)
            return root;

        return inorderSuccessor(root.right, x);

    }
}
