package com.decodejava.dsa.arrays.subarrayssum_prefsum.kadanes;

import java.util.Arrays;

public class Kadane_ObtainMaxSumSubArrayIndexes {
    public static int[] maxSumSubArrInd(int[] nums) {
        System.out.println("Given Array : " + Arrays.toString(nums));
        return kadanesAlgoMaxSumInd(nums);
    }

    private static int[] kadanesAlgoMaxSumInd(int[] nums) {
        //Kadane's Algorithm
        int max = Integer.MIN_VALUE, sum = 0, start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) start = i; // when there is a fresh start. then it could be then that index is the start.
            sum += nums[i];
            if (sum > max) {
                max = sum;
                end = i; // everytime the max in value is updated, then that max could be the max of all.
            }
            if (sum < 0) sum = 0; //There is no point in taking the neg sum forward to calculate the max sum, because it anyhow reduces the max sum.
        }
        if (max < 0) // if all the elements in the array are negetive, then there would only be one max i.e, the element near to 0.
            return new int[]{end, end}; // That max is already captured. we also know the index is end. so returning it. :)
        return new int[]{start, end};
    }
}
