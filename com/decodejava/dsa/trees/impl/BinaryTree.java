package com.decodejava.dsa.trees.impl;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.right = new Node<>(5);
        root.left.right.left = new Node<>(4);

        levelOrder(root);
        levelOrderLevelWise(root);
        displayPrettySide(root, 0);
    }

    public static void levelOrder(Node<?> root) {
        if (root == null) return;
        //level order traversal
        Queue<Node<?>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<?> ele = queue.poll();
            System.out.print(ele.data + " ");
            if (ele.left != null) {
                queue.add(ele.left);
            }
            if (ele.right != null) {
                queue.add(ele.right);
            }
        }
        System.out.println();
    }

    public static void levelOrderLevelWise(Node<?> root) {
        if (root == null) return;
        //level order traversal
        Queue<Node<?>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodesAtCurLevel = queue.size();
            while (nodesAtCurLevel-- > 0) {
                Node<?> ele = queue.poll();
                System.out.print(ele.data + " ");
                if (ele.left != null) {
                    queue.add(ele.left);
                }
                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void displayPrettySide(Node<?> root, int level) {
        if (root == null) return;
        displayPrettySide(root.right, level + 1);
        System.out.println("\t".repeat(level) + root.data);
        displayPrettySide(root.left, level + 1);
    }
}
