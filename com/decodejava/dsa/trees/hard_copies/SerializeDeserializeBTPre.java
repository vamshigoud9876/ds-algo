package com.decodejava.dsa.trees.hard_copies;

import com.decodejava.dsa.trees.impl.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeDeserializeBTPre {

    // Encodes a tree to a single string.
    public String serialize(Node<Integer> root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node<Integer> root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.data + ",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    int i;

    // Decodes your encoded data to tree.
    public Node<Integer> deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] arr = data.split(",");
        return deserializeHelper(arr);
    }

    private Node<Integer> deserializeHelper(String[] arr) {
        if (i >= arr.length || "N".equals(arr[i])) {
            i++;
            return null;
        }

        Node<Integer> root = new Node<>(Integer.parseInt(arr[i++]));
        root.left = deserializeHelper(arr);
        root.right = deserializeHelper(arr);
        return root;
    }
}

class SerializeDeserializeLevel {
    public String serializeLevel(Node<Integer> root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node<Integer> node = q.poll();
            if (node == null) {
                sb.append("N");
                if (!q.isEmpty())
                    sb.append(",");
                continue;
            }
            sb.append(node.data);
            q.add(node.left);
            q.add(node.right);
            if (!q.isEmpty())
                sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node<Integer> deserializeLevel(String data) {
        if (data.isEmpty())
            return null;
        String[] arr = data.split(",");
        Node<Integer> root = new Node<Integer>(Integer.parseInt(arr[0]));
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < arr.length; ) {
            Node<Integer> node = q.poll();

            node.left = (arr[i].equals("N")) ? null : new Node<Integer>(Integer.parseInt(arr[i]));
            if (node.left != null) q.add(node.left);
            i++;

            node.right = (arr[i].equals("N")) ? null : new Node<Integer>(Integer.parseInt(arr[i]));
            if (node.right != null) q.add(node.right);
            i++;
        }
        return root;
    }
}


