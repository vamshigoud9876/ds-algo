package com.decodejava.dsa.revision.recursion.combinationSubsets;

public class CombinationSumExists {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
    return helper(arr, 0, sum);
    }
    private static boolean helper(int[] arr, int ind, int remaining) {
        if (remaining == 0) {
            return true;
        }
        for (int i = ind; i < arr.length; i++) {
            if (helper(arr, i + 1, remaining - arr[i])) return true;
        }
        return false;
    }
}
