package com.decodejava.dsa.recursion.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
//time: 2^N
public class CombinationSumII {
    public static void main(String[] args) {
       int[] candidates = {10,1,2,7,6,1,5};
       int target = 8;
       for(List<Integer> list: combinationSum2(candidates, target)) {
           System.out.println(list);
       }
    }

    String img = "com/decodejava/dsa/recursion/resources/combination_sum_II.png";
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        diceProblem(candidates, target, new ArrayList<>(), ans, 0);
        return ans;
    }

    private static void diceProblem(int[] candidates, int remaining, List<Integer> ans, List<List<Integer>> finalAns, int startIndex) {
        if (remaining == 0) {
            List<Integer> temp = new ArrayList<>(ans);
            finalAns.add(temp);
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {//eg : 1 2 2 2 5
            if (i > startIndex && candidates[i - 1] == candidates[i]) {
                continue; // recursion wise we can take 2's
                // ie., in prev recursion if there was 2 then this recursion can have 2.
                // But in the same recur stack in the for loop we cant take same element as prev since it gives same combination.
            }
            if (remaining < candidates[i]) {
                break;
            }
            ans.add(candidates[i]);
            diceProblem(candidates, remaining - candidates[i], ans, finalAns, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}
