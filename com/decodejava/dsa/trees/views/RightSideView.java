package com.decodejava.dsa.trees.views;

import com.decodejava.dsa.trees.impl.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class RightSideView {
    public List<Integer> rightSideView(Node<Integer> root) {
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

        map.put(level, root.data);
        dfsHelper(root.left, level + 1, map);
        dfsHelper(root.right, level + 1, map);
    }
}
