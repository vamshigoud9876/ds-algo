package com.decodejava.dsa.arrays;

public class RotateLeftOrRight {
    public static void rotateRight(int[] nums, int k) {
        k = k % nums.length; int n = nums.length;
        reverse(0, n-k-1, nums);
        reverse(n-k, n-1, nums);
        reverse(0, n-1, nums);
    }
    public static void rotateLeft(int[] nums, int k) {
        k = k % nums.length; int n = nums.length;
        reverse(0, k-1, nums);
        reverse(k, n-1, nums);
        reverse(0, n-1, nums);
    }
    private static void reverse(int start, int end, int[] arr) {
        while (start<end) {
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;end--;
        }
    }
}
