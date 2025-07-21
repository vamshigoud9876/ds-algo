package com.decodejava.dsa.trees.serialize_deserialize;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/serialize-and-deserialize-bst/
public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(Node<Integer> root) {
        StringBuilder sb = new StringBuilder();
        preOrderHelper(root, sb);
        return sb.toString();

    }

    private void preOrderHelper(Node<Integer> root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.data).append(",");
        preOrderHelper(root.left, sb);
        preOrderHelper(root.right, sb);
    }

    int i;
    // Decodes your encoded data to tree.
    public Node<Integer> deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] arr = data.split(",");
        return deserializeFromPreorder(arr, Integer.MAX_VALUE);
    }

    private Node<Integer> deserializeFromPreorder(String[] arr, int upper) {
        if (i == arr.length) {
            return null;
        }

        int val = Integer.parseInt(arr[i]);
        if (val > upper)
            return null;
        i++;
        Node<Integer> root = new Node<>(val);
        root.left = deserializeFromPreorder(arr, val);
        root.right = deserializeFromPreorder(arr, upper);
        return root;

    }
}
