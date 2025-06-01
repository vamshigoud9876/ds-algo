package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class MaximumWidth {
    public int widthOfBinaryTree(Node<Integer> root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxWidth = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            int min = queue.peek().index;
            int start = 0, end = start;
            for(int i = 0; i < levelSize; i++) {
                Pair first = queue.poll();
                Node<Integer> node = first.node;
                int nodeInd = first.index - min;
                end = nodeInd;

                if (node.left != null) queue.add(new Pair(node.left, 2 * nodeInd));
                if (node.right != null) queue.add(new Pair(node.right, 2 * nodeInd + 1));
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        return maxWidth;
    }

    private static class Pair {
        Node<Integer> node;
        int index;
        public Pair(Node<Integer> n, int i) {
            node = n;
            index = i;
        }
    }

}
