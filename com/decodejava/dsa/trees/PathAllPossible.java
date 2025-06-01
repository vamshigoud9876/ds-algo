package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/
public class PathAllPossible {
    public List<String> binaryTreePaths(Node<Integer> root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, new StringBuilder());
        return ans;
    }
    public void helper(Node<Integer> root, List<String> ans, StringBuilder path) {
        if (root != null && root.left == null && root.right == null) {
            int len = path.length();
            path.append(root.data);
            ans.add(path.toString());
            path.delete(len, path.length());
            return;
        }

        if (root == null) return;

        int len = path.length();
        path.append(root.data);
        path.append("->");
        helper(root.left, ans, path);
        helper(root.right, ans, path);
        path.delete(len, path.length());
    }
}
