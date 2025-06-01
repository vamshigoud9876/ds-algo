package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class AverageOfLevels {
    public List<Double> averageOfLevels(Node<Integer> root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        //level order traversal
        Queue<Node<?>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long averageLevel = 0;
            int nodesAtCurLevel = queue.size(), n = nodesAtCurLevel;
            while (n-- > 0) {
                Node<?> ele = queue.poll();
                averageLevel += (Integer) ele.data;
                if (ele.left != null) {
                    queue.add(ele.left);
                }
                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }
            ans.add((double)averageLevel / nodesAtCurLevel);
        }
        return ans;
    }
}
