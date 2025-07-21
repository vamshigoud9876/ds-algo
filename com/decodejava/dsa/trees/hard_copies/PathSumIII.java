package com.decodejava.dsa.trees.hard_copies;

import com.decodejava.dsa.trees.impl.Node;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/path-sum-iii/
public class PathSumIII {

    public int pathSum(Node<Integer> root, int targetSum) {
        return sumHelper(root, 0, targetSum, new HashMap<>());
    }

    public int sumHelper(Node<Integer> root, long curSum, int target, Map<Long, Integer> prefMap) {
        if (root == null) return 0;
        curSum += root.data;
        int count = prefMap.getOrDefault(curSum - target, 0);
        if (curSum == target) count++;

        prefMap.put(curSum, prefMap.getOrDefault(curSum, 0) + 1);
        count += sumHelper(root.left, curSum, target, prefMap);
        count += sumHelper(root.right, curSum, target, prefMap);

        if (prefMap.get(curSum) == 1)
            prefMap.remove(curSum);
        else
            prefMap.put(curSum, prefMap.get(curSum) - 1);
        return count;
    }
}
