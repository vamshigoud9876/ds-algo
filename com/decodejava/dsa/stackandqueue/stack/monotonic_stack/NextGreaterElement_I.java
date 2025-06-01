package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElement_I {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }

    String img = "com/decodejava/dsa/stackandqueue/resources/next_greater_I.png";
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> greatersMap = new HashMap<>();
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while(!monotonicStack.isEmpty()) {
                if (nums2[monotonicStack.peek()] > nums2[i]) {
                    greatersMap.put(nums2[i], nums2[monotonicStack.peek()]);
                    break;
                }
                monotonicStack.pop();
            }
            monotonicStack.push(i);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = greatersMap.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
