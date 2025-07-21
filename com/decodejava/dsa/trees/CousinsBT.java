package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree/
public class CousinsBT {
    public boolean isCousins(Node
                                     <Integer> root, int x, int y) {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            boolean firstFound = false;
            boolean secondFound = false;
            while (n-- != 0) {
                Node<Integer> node = q.poll();
                if (node.data == x) firstFound = true;
                if (node.data == y) secondFound = true;
                if (node.left != null && node.right != null) {
                    if ((node.left.data == x && node.right.data == y)
                            || (node.left.data == y && node.right.data == x)) return false;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (firstFound && secondFound) return true;
        }
        return false;
    }
}
