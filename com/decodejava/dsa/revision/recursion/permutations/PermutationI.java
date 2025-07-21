package com.decodejava.dsa.revision.recursion.permutations;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class PermutationI {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAns = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0, finalAns);
        return finalAns;
    }

    public void helper(int[] nums, List<Integer> processed, int ind, List<List<Integer>> finalAns) {
        if (ind == nums.length) {
            finalAns.add(new ArrayList<>(processed));
            return;
        }

        int ele = nums[ind];

        for (int i = 0; i <= processed.size(); i++) {
            processed.add(i, ele);
            helper(nums, processed, ind + 1, finalAns);
            processed.remove(i);
        }
    }
}
