package com.decodejava.dsa.trees;

import com.decodejava.dsa.trees.impl.Node;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class KDistanceNodes {
    public List<Integer> distanceK(Node<Integer> root, Node<Integer> target, int k) {
        //evaluate parents map. O(N)
        //Spread by distance using queue. which at worst can be O(N). queue also O(N)

        Map<Node, Node> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        Queue<Node> queue = new LinkedList<>();
        Set<Node> vis = new HashSet<>();
        vis.add(target);
        List<Integer> ans = new ArrayList<>();
        queue.add(target);
        while (k != 0) {
            int size = queue.size();
            while (size-- != 0) {
                Node node = queue.poll();
                if (parentMap.containsKey(node) && !vis.contains(parentMap.get(node))) {
                    queue.add(parentMap.get(node));
                    vis.add(parentMap.get(node));
                }
                if (node.left != null && !vis.contains(node.left)) {
                    queue.add(node.left);
                    vis.add(node.left);
                }
                if (node.right != null && !vis.contains(node.right)) {
                    queue.add(node.right);
                    vis.add(node.right);
                }
            }
            k--;
        }
        queue.forEach(node -> ans.add((Integer) node.data));
        return ans;

    }

    private void buildParentMap(Node<Integer> root, Map<Node, Node> parentMap) {
        if (root == null) return;

        if (root.left != null) parentMap.put(root.left, root);
        if (root.right != null) parentMap.put(root.right, root);

        buildParentMap(root.left, parentMap);
        buildParentMap(root.right, parentMap);
    }
}
