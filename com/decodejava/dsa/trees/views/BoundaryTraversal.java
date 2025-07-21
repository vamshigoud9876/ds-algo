package com.decodejava.dsa.trees.views;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tree-gfg-160/problem/boundary-traversal-of-binary-tree
public class BoundaryTraversal {
    ArrayList<Integer> boundaryTraversal(Node<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.data);
        if (root.left == null && root.right == null) return res;
        leftBoundary(root.left, res);
        leafNodes(root, res);
        rightBoundary(root.right, res);
        return res;
    }

    public void leftBoundary(Node<Integer> root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;

        res.add(root.data);

        if (root.left != null)
            leftBoundary(root.left, res);
        else
            leftBoundary(root.right, res);
    }

    public void leafNodes(Node<Integer> root, List<Integer> res) {
        if (root == null) return;

        if (root.left == null && root.right == null)
            res.add(root.data);

        leafNodes(root.left, res);
        leafNodes(root.right, res);
    }

    public void rightBoundary(Node<Integer> root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;

        if (root.right != null)
            rightBoundary(root.right, res);
        else
            rightBoundary(root.left, res);

        res.add(root.data);

    }
}
