package com.decodejava.dsa.trees.sum;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/
public class PathSumII {
    public List<List<Integer>> pathSum(Node<Integer> root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, targetSum, ans, new ArrayList<>());
        return ans;
    }

    public void helper(Node<Integer> root, int targetSum, List<List<Integer>> ans, List<Integer> path) {
        if (root != null && root.left == null && root.right == null && targetSum == root.data) {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(root.data);
            ans.add(temp);
            return;
        }
        if (root == null) return;

        path.add(root.data);
        helper(root.left, targetSum - root.data, ans, path);
        helper(root.right, targetSum - root.data, ans, path);
        path.remove(path.size() - 1);
    }
}
