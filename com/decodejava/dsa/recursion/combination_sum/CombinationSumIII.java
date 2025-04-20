package com.decodejava.dsa.recursion.combination_sum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        for(List<Integer> list: combinationSum3(6, 6)) {
            System.out.print(list);
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        diceProblem(n, new ArrayList<>(), ans, 1, k);
        return ans;
    }

    private static void diceProblem(int remaining, List<Integer> ans, List<List<Integer>> finalAns, int index, int k) {
        if (remaining == 0 && ans.size() == k) {
            List<Integer> temp = new ArrayList<>(ans);
            finalAns.add(temp);
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (remaining < i && ans.size() >= k)
                break;
            ans.add(i);
            diceProblem(remaining - i, ans, finalAns, i + 1, k);
            ans.remove(ans.size() - 1);
        }
    }
}
