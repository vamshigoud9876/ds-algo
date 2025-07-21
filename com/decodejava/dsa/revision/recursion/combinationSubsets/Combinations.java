package com.decodejava.dsa.revision.recursion.combinationSubsets;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, 1, k, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int n, int ind, int k, List<Integer> taken, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(taken));
            return;
        }
        for (int i = ind; i <= n; i++) {
            taken.add(i);
            helper(n, i + 1, k - 1, taken, ans);
            taken.remove(taken.size() - 1);
        }
    }
}
