package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/balanced-binary-tree/
public class CheckHeightBalanced {
    public boolean isBalanced(Node<Integer> root) {
        return checkBalanceHelper(root) != -1;
    }

    private int checkBalanceHelper(Node<Integer> root) {
        if (root == null) return 0;

        int leftHeight = checkBalanceHelper(root.left);
        int rightHeight = checkBalanceHelper(root.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
