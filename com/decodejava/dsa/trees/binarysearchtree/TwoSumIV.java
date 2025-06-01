package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSumIV {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(Node<Integer> root, int k) {
        if (root == null) return false;

        boolean left = findTarget(root.left, k);
        if (left) return true;
        if(set.contains(k - root.data)) return true;
        set.add(root.data);
        return findTarget(root.right, k);
    }
}
