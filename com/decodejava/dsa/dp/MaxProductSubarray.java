package com.decodejava.dsa.dp;

public class MaxProductSubarray {
    public static void main(String[] args) {
        System.out.println(new MaxProductSubarray().maxProduct(new int[]{2,3,-2,4}));
    }
    public int maxProduct(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
           ans = Math.max(ans, Math.max(left[i], right[i]));
        }
        return ans;
    }
}
