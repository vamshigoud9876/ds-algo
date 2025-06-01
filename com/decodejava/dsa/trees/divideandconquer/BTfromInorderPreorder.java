package com.decodejava.dsa.trees.divideandconquer;

import com.decodejava.dsa.trees.impl.Node;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class BTfromInorderPreorder {
    int i = 0;
    public Node<Integer> buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            inOrderMap.put(inorder[i], i);
        return buildTreeHelper(preorder, inOrderMap, 0, inorder.length - 1);
    }

    public Node<Integer> buildTreeHelper(int[] preorder, Map<Integer, Integer> inOrderMap, int start, int end) {
        if (start > end) return null;

        Node<Integer> root = new Node<Integer>(preorder[i]);
        int index = inOrderMap.get(preorder[i]);
        i++;
        root.left = buildTreeHelper(preorder, inOrderMap, start, index - 1);
        root.right = buildTreeHelper(preorder, inOrderMap, index + 1, end);
        return root;
    }
}
