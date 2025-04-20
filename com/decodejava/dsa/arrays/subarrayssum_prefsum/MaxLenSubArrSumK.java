package com.decodejava.dsa.arrays.subarrayssum_prefsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.text.MessageFormat.format;

public class MaxLenSubArrSumK {
    public static int longestSubarray(int[] arr, int k) {
        /**
         * Bruteforce - find all the possible subarrays and sumup and match the given sum to get max length.
         * better - hashing and prefixSum > 2, 3, 5
         *                                  /   \
         * Keep storing the prefix sum in a hashMap with index.
         * Whenever we land on index i, then check whether curSum-k exists in the hashmap.
         * That means, If there exists sum curSum-k, then from {curSum-k, ind} index to i gives me the length of the subarr with
         * given sum.
         */
        System.out.println(format("{0} K = {1}", Arrays.toString(arr), k));
        int brute = bruteForceApproach(arr, k);
        int hash = hashingApproach(arr, k);
        int optimal = optimalApproach(arr, k);
        return hash;

    }

    /**
     * o(n^3)
     */
    private static int bruteForceApproach(int[] arr, int k) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {//generate all possible subarrays
                    sum += arr[l];
                }
                if (sum == k) max = Integer.max(max, j - i + 1);
            }
        }
        return max;
    }

    /**
     *
     *  Works for both positives and negative numbers
     *  time complexity O(n) if no collisions occur for hashmap
     *  extra space O(n)
     */
    private static int hashingApproach(int[] arr, int k) {
        int sum = 0, max = 0;
        Map<Integer, Integer> prefixSumHash = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k)
                max = Integer.max(max, i + 1);
            if (prefixSumHash.containsKey(sum - k))
                max = Integer.max(max, i - prefixSumHash.get(sum - k));
            if (!prefixSumHash.containsKey(sum))
                prefixSumHash.put(sum, i);
        }
        return max;
    }

    private static int optimalApproach(int[] arr, int k) {
        /**
         * doesn't work for the negative numbers.
         */
        int left = 0, right = 0, max = 0;
        long prefixSum = 0;
        while (right < arr.length) {
            prefixSum += arr[right];
            if (prefixSum == k) {
                max = Integer.max(max, right - left + 1);
            }
            while (prefixSum > k && left <= right) {
                prefixSum -= arr[left];
                left++;
            }
            right++;
        }
        return max;
    }

}
