package com.decodejava.dsa.revision.recursion.combinationSubsets;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> finalAns = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), finalAns);
        return finalAns;
    }

    private void helper(int k, int target, int ind, List<Integer> ans, List<List<Integer>> finalAns) {
        if (target == 0) {
            if (ans.size() == k)
                finalAns.add(new ArrayList<>(ans));
            return;
        }

        for (int i = ind; i <= 9; i++) {
            if (target - i < 0) return;
            ans.add(i);
            helper(k, target - i, i + 1, ans, finalAns);
            ans.remove(ans.size() - 1);
        }
    }
}
