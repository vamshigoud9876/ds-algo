package com.decodejava.dsa.trees.bfs;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void levelOrder(Node<?> root, List<Integer> ans) {
        if (root == null) return;
        //level order traversal
        Queue<Node<?>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<?> ele = queue.poll();
            ans.add((Integer) ele.data);
            if (ele.left != null) {
                queue.add(ele.left);
            }
            if (ele.right != null) {
                queue.add(ele.right);
            }
        }
        System.out.println();
    }

    public static void levelOrderLevelWise(Node<?> root, List<List<Integer>> ans) {
        if (root == null) return;
        //level order traversal
        Queue<Node<?>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodesAtCurLevel = queue.size();
            List<Integer> eachLevel = new ArrayList<>();
            while (nodesAtCurLevel-- > 0) {
                Node<?> ele = queue.poll();
                eachLevel.add((Integer) ele.data);
                if (ele.left != null) {
                    queue.add(ele.left);
                }
                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }
            ans.add(eachLevel);
        }
    }
}
