package com.decodejava.dsa.revision.recursion.combinationSubsets;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0, ans);
        return ans;
    }

    private void helper(int[] nums, List<Integer> processed, int ind, List<List<Integer>> finalAns) {
        if (ind == nums.length) {
            if (processed.size() > 1)
                finalAns.add(new ArrayList<>(processed));
            return;
        }

        int ele = nums[ind];

        //ignore it
        if (processed.isEmpty() || ele != processed.get(processed.size() - 1))
            helper(nums, processed, ind + 1, finalAns);

        if (processed.isEmpty() || ele >= processed.get(processed.size() - 1)) {
            //take it
            processed.add(ele);
            helper(nums, processed, ind + 1, finalAns);
            processed.remove(processed.size() - 1);
        }
    }
}
