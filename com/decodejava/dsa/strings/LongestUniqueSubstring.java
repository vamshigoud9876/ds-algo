package com.decodejava.dsa.strings;

public class LongestUniqueSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 1, max = 0, count = 1;
        while (right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                int len = right - left;
                if(len > max) max = len;
                left++;
            } else {
                right++;
            }
        }
        int len = right - left;
        return Integer.max(len, max);
    }

    }
