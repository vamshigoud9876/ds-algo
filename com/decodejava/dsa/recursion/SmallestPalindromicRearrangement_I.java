package com.decodejava.dsa.recursion;

import java.util.Map;
import java.util.TreeMap;

public class SmallestPalindromicRearrangement_I {

//    3517. Smallest Palindromic Rearrangement I

//    Input: s = "babab"
//    Output: "abbba"
//    Explanation: Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.
//    https://leetcode.com/problems/smallest-palindromic-rearrangement-i/

    public String smallestPalindrome(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        String mid = "";
        for(int i = 0; i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        System.out.println(map);
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if((count % 2) == 0) {
                while(count > 0) {
                    sb.append(entry.getKey());
                    count -= 2;
                }
            } else {
                mid = entry.getKey()+""; count--;
                while(count > 0) {
                    sb.append(entry.getKey());
                    count -= 2;
                }
            }
        }
        return sb + mid + sb.reverse();
    }
}
