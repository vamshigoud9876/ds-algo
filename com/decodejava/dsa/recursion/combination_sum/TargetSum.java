package com.decodejava.dsa.recursion.combination_sum;

//https://leetcode.com/problems/target-sum/

//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//        -1 + 1 + 1 + 1 + 1 = 3
//        +1 - 1 + 1 + 1 + 1 = 3
//        +1 + 1 - 1 + 1 + 1 = 3
//        +1 + 1 + 1 - 1 + 1 = 3
//        +1 + 1 + 1 + 1 - 1 = 3
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return sumWaysHelper(nums, target, 0, 0);
    }
    public int sumWaysHelper(int[] nums, int target, int comb, int start) {
        if (start == nums.length) {
            if(target == comb)
                return 1;
            else
                return 0;
        }

        int num = nums[start];

        int count1 = sumWaysHelper(nums, target, comb + num, start + 1);
        int count2 = sumWaysHelper(nums, target, comb - num, start + 1);
        return count1 + count2;
    }
}
