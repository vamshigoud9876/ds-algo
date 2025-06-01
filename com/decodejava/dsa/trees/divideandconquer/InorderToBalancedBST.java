package com.decodejava.dsa.trees.divideandconquer;

import com.decodejava.dsa.trees.impl.Node;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class InorderToBalancedBST {
    public Node<Integer> sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public Node<Integer> helper(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node<Integer> newNode = new Node<Integer>(nums[mid]);
        newNode.left = helper(nums, start, mid - 1);
        newNode.right = helper(nums, mid + 1, end);
        return newNode;
    }
}
