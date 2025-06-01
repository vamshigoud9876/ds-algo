package com.decodejava.dsa.trees.sum;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/path-sum/
public class PathSum {
    public boolean hasPathSum(Node<Integer> root, int targetSum) {
        if (root != null && root.left == null && root.right == null && targetSum == root.data) {
            return true;
        }
        if (root == null)return false;

        boolean isFound = hasPathSum(root.left, targetSum - root.data);
        if (!isFound) {
            isFound = hasPathSum(root.right, targetSum - root.data);
        }
        return isFound;
    }
}
