package com.decodejava.dsa.trees;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersI {

    public Node connect(Node root) {
        Node leftMost = root, cur = root;
        if (root == null) return null;
        while(leftMost.left != null) {
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = (cur.next == null) ? null : cur.next.left;
                cur = cur.next;
            }
            leftMost = leftMost.left;
            cur = leftMost;
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
