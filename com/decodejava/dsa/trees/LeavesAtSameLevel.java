package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

public class LeavesAtSameLevel {
    int leafLevel = -1;
    boolean check(Node<Integer> root) {
        return helper(root, 0);
    }

    boolean helper(Node<Integer> root, int level) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            if (leafLevel == -1) leafLevel = level;
            else return leafLevel == level;
        }
        boolean left = helper(root.left, level + 1);
        if (!left) return false;
        return helper(root.right, level + 1);
    }
}
