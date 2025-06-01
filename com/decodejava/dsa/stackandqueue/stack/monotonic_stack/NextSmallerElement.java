package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 1, 6, 10, 5};
        System.out.println(Arrays.toString(nextSmallerElements(arr)));
    }

    public static int[] nextSmallerElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            boolean smallerFound = false;
            while (!stack.isEmpty()) {
                if (stack.peek() < nums[i]) {
                    ans[i] = stack.peek();
                    smallerFound = true;
                    break;
                }
                stack.pop();
            }
            if (!smallerFound) {
                ans[i] = -1;
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}
