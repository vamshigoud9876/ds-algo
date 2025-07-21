package com.decodejava.dsa.revision.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> finalAns = new ArrayList<>();
        helper(new ArrayList<>(), s, 0, finalAns);
        return finalAns;
    }

    private void helper(List<String> processed, String unprocessed, int upStart, List<List<String>> finalAns) {
        if (upStart == unprocessed.length()) {
            finalAns.add(new ArrayList<>(processed));
            return;
        }

        for (int i = upStart; i < unprocessed.length(); i++) {
            if (isPalindrome(unprocessed, upStart, i)) {
                processed.add(unprocessed.substring(upStart, i + 1));
                helper(processed, unprocessed, i+1, finalAns);
                processed.remove(processed.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substring, int start, int end) {
        while(start < end) {
            if (substring.charAt(start) != substring.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
