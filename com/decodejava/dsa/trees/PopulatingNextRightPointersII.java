package com.decodejava.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class PopulatingNextRightPointersII {

    private Node connect(Node root) {
        if(root == null) return null;
        //Bfs
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while(levelSize-- != 0) {
                Node ele = queue.poll();
                if (levelSize > 0) {
                    ele.next = queue.peek();
                }
                if(ele.left != null) queue.add(ele.left);
                if(ele.right != null) queue.add(ele.right);
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
