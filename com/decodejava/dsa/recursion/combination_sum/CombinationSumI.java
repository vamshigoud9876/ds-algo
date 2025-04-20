package com.decodejava.dsa.recursion.combination_sum;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//time : N^T
public class CombinationSumI {
    public static void main(String[] args) {
        int[] candidates = {8,7,4,3};
        int target = 11;
        for(List<Integer> list: combinationSum(candidates, target)) {
            System.out.print(list);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        diceProblem(candidates, target, new ArrayList<>(), ans, 0);
        return ans;
    }
    private static void diceProblem(int[] candidates, int remaining, List<Integer> ans, List<List<Integer>> finalAns, int candInd) {
        if(remaining == 0) {
            List<Integer> temp = new ArrayList<>(ans);
            finalAns.add(temp);
            return;
        }
        for (int i = candInd; i < candidates.length; i++) {
            if (remaining >= candidates[i]) {
                ans.add(candidates[i]);
                diceProblem(candidates, remaining - candidates[i], ans, finalAns, i);
                ans.remove(ans.size() - 1);
            }
        }
    }

}
