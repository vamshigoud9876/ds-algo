package com.decodejava.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhone {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    String img = "com/decodejava/dsa/recursion/resources/letters_combinations.png";
    public static List<String> letterCombinations(String digits) {
    //using map
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return genLetters(new StringBuilder(), digits, 0, map);
    }

    static List<String> genLetters(StringBuilder processed, String unprocessed, int index,  Map<Character, String> map) {
        if(unprocessed.length() == index) {
            List<String> list = new ArrayList<>();
            list.add(processed.toString());
            return list;
        }
        char ch = unprocessed.charAt(index);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < map.get(ch).length(); i++) {
            processed.append(map.get(ch).charAt(i));
            List<String> item = genLetters(processed, unprocessed, index + 1, map);
            processed.deleteCharAt(processed.length() - 1); //backtrack
            ans.addAll(item);
        }
        return ans;
    }
}
