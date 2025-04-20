package com.decodejava.dsa.arrays._234Sum_2pointer;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        return optimalApproach(nums);
    }

    private static List<List<Integer>> bruteForceSolution(int[] nums) {
        // Naive Solution : 3 for loops
        //Time: n^3
        //space: K being the number of unique triplets
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(null);
                        set.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    private static List<List<Integer>> betterSolution(int[] nums) {
        // We can find 2Sum in O(N) approach, so if we iterate and for every nums[i], we will find the 2two sum from i+1 that equals to -nums[i]
        // because the total sum would be 0.

        //      1, -2, 1
        //      ^  <--->
        //      1   -1  -> we need -1 then triplet sum is 0.
        //Time: n^3
        //space: K being the number of unique triplets
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int find = -nums[i];
            Set<Integer> hash = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
                int ans = find - nums[j];
                if (hash.contains(ans)) {
                    List<Integer> triplet = Arrays.asList(nums[i], ans, nums[j]);
                    triplet.sort(null);
                    set.add(triplet);
                }
                hash.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }

    private static ArrayList<List<Integer>> optimalApproach(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //skip duplicates that's useless to compute
            if(i>0 && nums[i] == nums[i-1]) continue;
            //two pointers: from 2Sum
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;//skip duplicates that's useless to compute
                    while(k > j && nums[k] == nums[k + 1]) k--;//skip duplicates that's useless to compute
                }
                else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }
        return new ArrayList<>(set);
    }
}
