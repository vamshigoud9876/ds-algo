package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElement_II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
    }
    String img = "com/decodejava/dsa/stackandqueue/resources/next_greater_II.png";
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> monotonicStack = new Stack<>();
        int[] ans = new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            boolean greaterFound = false;
            int k = i % nums.length;
            while(!monotonicStack.isEmpty()) {
                if (monotonicStack.peek() > nums[k]) {
                    ans[k] = monotonicStack.peek();
                    greaterFound = true;
                    break;
                }
                monotonicStack.pop();
            }
            if(!greaterFound) ans[k] = -1;
            monotonicStack.push(nums[k]);
        }
        return ans;
    }
}
