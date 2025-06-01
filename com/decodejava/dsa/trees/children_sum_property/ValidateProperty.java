package com.decodejava.dsa.trees.children_sum_property;

import com.decodejava.dsa.trees.impl.Node;

//https://www.geeksforgeeks.org/problems/children-sum-parent/1
public class ValidateProperty {
    public static int isSumProperty(Node<Integer> root) {
        if (root == null) return 1;
        if (root.left != null && root.right != null && root.left.data + root.right.data != root.data) return 0;
        if (root.left != null && root.right == null && root.left.data != root.data) return 0;
        if (root.right != null && root.left == null && root.right.data != root.data) return 0;

        return isSumProperty(root.left) == 0 ? 0 : isSumProperty(root.right);
    }
}
