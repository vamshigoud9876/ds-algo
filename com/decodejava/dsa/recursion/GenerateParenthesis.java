package com.decodejava.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(new StringBuilder(), ans, n, 0);
        return ans;
    }

    private void helper(StringBuilder comb, List<String> ans, int n, int openCount) {
        if (openCount > n)
            return;
        if (n == 0) {
            ans.add(comb.toString());
            return;
        }

        helper(comb.append("("), ans, n, openCount + 1);
        comb.deleteCharAt(comb.length() - 1);

        //right
        if (openCount > 0) {
            helper(comb.append(")"), ans, n - 1, openCount - 1);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
