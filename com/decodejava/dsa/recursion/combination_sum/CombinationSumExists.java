package com.decodejava.dsa.recursion.combination_sum;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class CombinationSumExists {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSum(arr, sum));
    }
    static Boolean isSubsetSum(int[] arr, int sum) {
        Arrays.sort(arr);
        return diceProblem(arr, sum, 0);
    }
    private static boolean diceProblem(int[] candidates, int remaining, int candInd) {
        if (remaining == 0) {
            return true;
        }
        if (candInd == candidates.length) {
            return false;
        }
        for (int i = candInd; i < candidates.length; i++) {
            if (remaining < candidates[i]) return false;
            if (diceProblem(candidates, remaining - candidates[i], i + 1)) return true;
        }
        return false;
    }
}
