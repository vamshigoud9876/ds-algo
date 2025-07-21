package com.decodejava.dsa.trees.views;

import com.decodejava.dsa.trees.impl.Node;
import java.util.*;


//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(Node<Integer> root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        helper(root, 0, map, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer, Map<Integer, List<Integer>>> e : map.entrySet()) {
            List<Integer> li = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> inner: e.getValue().entrySet()) {
                List<Integer> inr = inner.getValue();
                Collections.sort(inr);
                for(int ele: inr) li.add(ele);
            }
            ans.add(li);
        }
        return ans;
    }

    public void helper(Node<Integer> root, int offset, Map<Integer, Map<Integer, List<Integer>>> map, int level) {
        if (root == null) return;
        Map<Integer, List<Integer>> inner = map.getOrDefault(offset, new TreeMap());
        List<Integer> li = inner.getOrDefault(level, new ArrayList<>());
        li.add(root.data);
        inner.put(level, li);
        map.put(offset, inner);
        helper(root.left, offset - 1, map, level + 1);
        helper(root.right, offset + 1, map, level + 1);
    }
}
