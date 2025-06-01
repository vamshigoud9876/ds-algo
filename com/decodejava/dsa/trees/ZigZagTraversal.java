package com.decodejava.dsa.trees;


import com.decodejava.dsa.trees.impl.Node;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node<Integer>> queue = new ArrayDeque<>();

        queue.add(root);
        boolean isForward = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelArr = new LinkedList<>();

            while (levelSize-- > 0) {
                Node<Integer> node = queue.poll();
                if (isForward) levelArr.addLast(node.data);
                else levelArr.addFirst(node.data);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(levelArr);
            isForward = !isForward;
        }
        return ans;
    }
}
