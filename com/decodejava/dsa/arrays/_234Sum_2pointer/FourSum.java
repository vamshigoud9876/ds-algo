package com.decodejava.dsa.arrays._234Sum_2pointer;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return optimalApproach(nums, target);
//        return bruteForce(nums, target);
    }

    private static List<List<Integer>> optimalApproach(int[] nums, int target) {
        //Time: n^3
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i-1] == nums[i+1]) continue;
            for (int a = i + 1; a < nums.length; a++) {
                //two pointers: j , k
                int j = a + 1, k = nums.length - 1;
                while (j < k) {
                    long sum = (long) nums[i] + (long) nums[a] + (long) nums[j] + (long) nums[k];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[a] , nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    } else if (sum < target)
                        j++;
                    else
                        k--;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    private static ArrayList<List<Integer>> bruteForce(int[] nums, int target) {
        // Naive Solution : 4 for loops
        //Time: n^4
        //space: K being the number of unique triplets
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            quad.sort(null);
                            set.add(quad);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    private static List<List<Integer>> betterSolution(int[] nums, int target) {
        //Time: n^3
        //space: K being the number of unique triplets
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) { // we fix i and j to find 2two of 3rd and 4th numbers
                Set<Long> hash = new HashSet<>();
                for (int k = j+1; k < nums.length; k++) {
                    long _3Sum = (long)nums[i] + (long)nums[j] + (long)nums[k];
                    long _4th = target - _3Sum;
                    if (hash.contains(_4th)) {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], (int)_4th, nums[k]);
                        quad.sort(null);
                        set.add(quad);
                    }
                    hash.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
