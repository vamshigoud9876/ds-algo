package com.decodejava.dsa.arrays.subarrayssum_prefsum.kadanes;

import java.util.Arrays;

public class Kadane_ObtainMaxSumSubArray {
    public static int maxSubArray(int[] nums) {
        System.out.println("Given Array" + Arrays.toString(nums));
//        return bruteForceGenAllSubArr(nums);
//        return bruteForceSubArrOptimal(nums);
        return kadanesAlgoMaxSum(nums);
    }

    private static int bruteForceSubArrOptimal(int[] nums) {
        //Time Complexity : n^2
        //BruteForce: Generate all the subarrays to find the max sum
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
            }
            max = Integer.max(max, sum);
        }
        return max;
    }

    private static int bruteForceGenAllSubArr(int[] nums) {
        //Time Complexity : n^3
        //BruteForce: Generate all the subarrays to find the max sum
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max = Integer.max(max, sum);
            }
        }
        return max;
    }

    private static int kadanesAlgoMaxSum(int[] nums) {
        //Kadane's Algorithm
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Integer.max(max, sum);
            if (sum < 0) sum = 0; //There is no point in taking the neg sum forward to calculate the max sum, because it anyhow reduces the max sum.
        }
        return max;
    }
}
