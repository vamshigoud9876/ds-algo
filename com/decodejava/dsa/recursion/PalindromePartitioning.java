package com.decodejava.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }

    String img = "com/decodejava/dsa/recursion/resources/palindrome_partition.png";
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void partitionHelper(String up, int upStart, List<String> ans, List<List<String>> finalAns) {
        if (upStart == up.length()) {
            List<String> temp = new ArrayList<>(ans);
            if (!ans.isEmpty())
                finalAns.add(temp);
            ans.clear();
            return;
        }
        for (int i = upStart; i < up.length(); i++) {
            boolean isPalindrome = isPalindrome(upStart, i, up);
            if (isPalindrome) {
                ans.add(up.substring(upStart, i + 1));
                partitionHelper(up, i + 1, ans, finalAns);
            }

        }
    }

    private boolean isPalindrome(int start, int end, String cur) {
        while (start < end) {
            if(cur.charAt(start) != cur.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
