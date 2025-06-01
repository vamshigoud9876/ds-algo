package com.decodejava.dsa.trees.views;

import com.decodejava.dsa.trees.impl.Node;

import java.util.*;

//https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1?
public class LeftSideView {
    public List<Integer> leftSideView(Node<Integer> root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        dfsHelper(root, 0, map);
        int n = map.size();
        while (n-- != 0)
            ans.add(map.get((map.size() - n) - 1));
        return ans;
    }

    public void dfsHelper(Node<Integer> root, int level, Map<Integer, Integer> map) {
        if (root == null) return;

        if (!map.containsKey(level))
            map.put(level, root.data);
        dfsHelper(root.left, level + 1, map);
        dfsHelper(root.right, level + 1, map);
    }

    ArrayList<Integer> leftViewBFS(Node root) {
        if (root == null) return new ArrayList<>();
        //level order traversal
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodesAtCurLevel = queue.size(), n = nodesAtCurLevel;
            while (nodesAtCurLevel-- > 0) {
                Node ele = queue.poll();
                if (nodesAtCurLevel == n - 1)
                    ans.add((Integer) ele.data);
                if (ele.left != null) {
                    queue.add(ele.left);
                }
                if (ele.right != null) {
                    queue.add(ele.right);
                }
            }
        }
        return ans;
    }
}
