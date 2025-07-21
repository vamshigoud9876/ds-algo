package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

import java.util.*;

//https://www.geeksforgeeks.org/problems/burning-tree/1
//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
public class BurnTree {
    public static int minTime(Node root, int target) {

        Node start = findNode(root, target);

        Map<Node, Node> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        Set<Node> burntSet = new HashSet<>();
        Queue<Node> burntQueue = new LinkedList<>();

        burntQueue.add(start);
        burntSet.add(start);

        int timeTaken = 0;
        while (!burntQueue.isEmpty()) {
            int size = burntQueue.size();
            boolean unBurnExists = false;
            while (size-- != 0) {
                Node node = burntQueue.poll();
                //burn parent if exists and unburned
                if (parentMap.containsKey(node) && !burntSet.contains(parentMap.get(node))) {
                    burntSet.add(parentMap.get(node));
                    burntQueue.add(parentMap.get(node));
                    unBurnExists = true;
                }
                //burn left child if exists and unburned
                if (node.left != null && !burntSet.contains(node.left)) {
                    burntSet.add(node.left);
                    burntQueue.add(node.left);
                    unBurnExists = true;
                }
                //burn left child if exists and unburned
                if (node.right != null && !burntSet.contains(node.right)) {
                    burntSet.add(node.right);
                    burntQueue.add(node.right);
                    unBurnExists = true;
                }
            }
            if (unBurnExists)
                timeTaken++;
        }

        return timeTaken;
    }

    private static void buildParentMap(Node root, Map<Node, Node> parentMap) {
        if (root == null) return;

        if (root.left != null) parentMap.put(root.left, root);
        if (root.right != null) parentMap.put(root.right, root);

        buildParentMap(root.left, parentMap);
        buildParentMap(root.right, parentMap);
    }

    private static Node findNode(Node root, int target) {
        if (root == null) return null;

        if ((Integer) root.data == target) return root;

        Node node = findNode(root.left, target);
        return node == null ? findNode(root.right, target) : node;
    }
}
