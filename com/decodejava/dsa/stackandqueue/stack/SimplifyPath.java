package com.decodejava.dsa.stackandqueue.stack;

import java.util.Stack;

//https://leetcode.com/problems/simplify-path/
public class SimplifyPath {
    public String simplifyPath(String path) {
        int i = 0;
        Stack<StringBuilder> stack = new Stack<>();
        while ( i < path.length()) {
            StringBuilder dir = new StringBuilder();
            while (i < path.length() && path.charAt(i) != '/') {
                dir.append(path.charAt(i));
                i++;
            }
            if (dir.isEmpty()) i++;
            if (dir.toString().equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!dir.isEmpty() && !dir.toString().equals("..") && !dir.toString().equals("."))
                stack.push(dir.insert(0, "/"));
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.isEmpty() ? "/" : ans.toString();
    }
}
