package com.decodejava.dsa.recursion.combination_sum;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/
public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combineHelper(new ArrayList<>(), k, n, ans, 1);
        return ans;
    }
    public static void combineHelper(List<Integer> list, int k, int n, List<List<Integer>> ans, int start) {
        if (k == 0) {
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            combineHelper(list, k - 1, n, ans, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
