package com.decodejava.dsa.revision.recursion.combinationSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    private void helper(int[] arr, int ind, int remaining, List<Integer> ele, List<List<Integer>> ans) {
        if (remaining == 0) {
            ans.add(new ArrayList<>(ele));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (remaining - arr[i] < 0)
                break;
            ele.add(arr[i]);
            helper(arr, i, remaining - arr[i], ele, ans);
            ele.remove(ele.size() - 1);
        }
    }
}
