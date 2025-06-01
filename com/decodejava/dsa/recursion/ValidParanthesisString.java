package com.decodejava.dsa.recursion;

//https://leetcode.com/problems/valid-parenthesis-string/
public class ValidParanthesisString {
    public boolean checkValidString(String s) {
        return helper(s, 0,  0);
    }
    public boolean helper(String s, int index, int open) {
        if(index == s.length()) {
            if(open == 0)
                return true;
            return false;
        }

        char ch = s.charAt(index);


        if (ch == '(') {
            return helper(s, index + 1, open + 1);
        } else if(ch == ')') {
            if(open == 0) //it should only start with '(' not ')'
                return false;
            return helper(s, index + 1, open - 1);
        } else {
            boolean takeOpen = helper(s, index + 1, open + 1);
            boolean takeClose = false;
            if(open != 0)
                takeClose = helper(s, index + 1, open - 1);
            boolean takeNothing = helper(s, index + 1, open);
            return takeOpen || takeClose || takeNothing;
        }
    }
}
