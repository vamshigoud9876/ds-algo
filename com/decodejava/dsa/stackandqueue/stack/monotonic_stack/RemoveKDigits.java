package com.decodejava.dsa.stackandqueue.stack.monotonic_stack;

import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int[] remove = new int[num.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k != 0) {
                if (num.charAt(stack.peek()) > num.charAt(i)) {
                    remove[stack.pop()] = -1;
                    k--;
                } else {break;}
            }
            stack.push(i);
        }
        while (!stack.isEmpty() && k != 0) {
            remove[stack.pop()] = -1;
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (remove[i] != -1 && !(sb.isEmpty() && num.charAt(i) == '0')) {
                sb.append(num.charAt(i));
            }
        }
        if (sb.isEmpty())
            return "0";
        return sb.toString();
    }
}
