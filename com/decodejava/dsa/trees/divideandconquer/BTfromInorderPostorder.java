package com.decodejava.dsa.trees.divideandconquer;

import com.decodejava.dsa.trees.impl.Node;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class BTfromInorderPostorder {
    int i;
    public Node<Integer> buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            inOrderMap.put(inorder[i], i);
        i = postorder.length - 1;
        return buildTreeHelper(postorder, inOrderMap, 0, inorder.length - 1);
    }

    public Node<Integer> buildTreeHelper(int[] postorder, Map<Integer, Integer> inOrderMap, int start, int end) {
        if (start > end) return null;

        Node<Integer> root = new Node<>(postorder[i]);
        int index = inOrderMap.get(postorder[i]);
        i--;
        root.right = buildTreeHelper(postorder, inOrderMap, index + 1, end);
        root.left = buildTreeHelper(postorder, inOrderMap, start, index - 1);
        return root;
    }
}
