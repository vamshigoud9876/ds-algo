package com.decodejava.dsa.trees.binarysearchtree;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallest {
    static int count = 1;

    public static void main(String[] args) {
        Node<Integer> root = BstImpl.buildBST();
        System.out.println(kthSmallest(root, 2));
        count = 1;
        System.out.println(kthLargest(root, 3));
    }

    public static int kthSmallest(Node<Integer> root, int k) {
        if (root == null) return -1;
        int ans = kthSmallest(root.left, k);
        if (ans != -1) return ans;
        if (k == count)
            return root.data;
        count++;
        ans = kthSmallest(root.right, k);
        return ans;
    }

    public static int kthLargest(Node<Integer> root, int k) {
        if (root == null) return -1;
        int ans = kthLargest(root.right, k);
        if (ans != -1) return ans;
        if (k == count)
            return root.data;
        count++;
        ans = kthLargest(root.left, k);
        return ans;
    }
}
