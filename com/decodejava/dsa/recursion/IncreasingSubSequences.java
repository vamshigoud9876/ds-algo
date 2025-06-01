package com.decodejava.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/non-decreasing-subsequences/
public class IncreasingSubSequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0, ans);
        return ans;
    }
    public void helper(int[] nums, List<Integer> taken, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>(taken);
            ans.add(temp);
            return;
        }
        int num = nums[index];

        if (taken.isEmpty() || taken.get(taken.size() - 1) < num) {
            //takeit
            taken.add(num);
            helper(nums, taken, index + 1, ans);
            taken.remove(taken.size() - 1);
        }
        int i = index - 1;
        while(i < nums.length && nums[i] == nums[i - 1]) i++;
        //dont take it
        helper(nums, taken, i + 1, ans);
    }
}
