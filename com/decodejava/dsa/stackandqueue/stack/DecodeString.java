package com.decodejava.dsa.stackandqueue.stack;

import java.util.Stack;

//    https://leetcode.com/problems/decode-string
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder num = new StringBuilder();
        for(int i = 0 ; i < s.length();i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num.append(s.charAt(i));
                continue;
            }
            if (!num.isEmpty()) {
                stack.push(num.toString());
                num = new StringBuilder();
            }
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i)+"");
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while(!stack.isEmpty()) {
                String popped = stack.pop();
                if ("[".equals(popped)) break;
                temp.insert(0, popped);
            }
            stack.push(temp.toString().repeat(Integer.parseInt(stack.pop())));
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}
