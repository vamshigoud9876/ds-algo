package com.decodejava.dsa.recursion.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

        System.out.println(permuteStrRec(new StringBuilder(), "abcd", 0));
        System.out.println(countPermuteStrRec(new StringBuilder(), "abcd", 0));
        System.out.println(permuteArrRec(new ArrayList<>(), List.of(1, 2, 3), 0));
    }

    String img = "com/decodejava/dsa/recursion/resources/permute_str_rec.png";
    public static List<String> permuteStrRec(StringBuilder processed, String unprocessed, int index) {
        if(unprocessed.length() <= index) {
            return List.of(processed.toString());// important
            //this will create the copy of processed i.e, create a new string to store new string reference
            //else the backtracking causes to lose of elements.
        }
        List<String> ans = new ArrayList<>();
        char ch = unprocessed.charAt(index);
        int n = processed.length();
        for (int i = 0; i <= n; i++) {
            processed.insert(i, ch);//insert at i
            ans.addAll(permuteStrRec(processed, unprocessed, index + 1));
            //remember same processed object is passed to future recursion, they will mutate ur builder,
            //remove your change when u are done with your call.
            processed.deleteCharAt(i);//backtrack
        }
        return ans;
    }

    String img1 = "com/decodejava/dsa/recursion/resources/permute_str_rec.png";
    public static List<List<Integer>> permuteArrRec(ArrayList<Integer> processed, List<Integer> unprocessed, int index) {
        if(unprocessed.size() == index) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            lists.add(new ArrayList<>(processed));//*** important to store the copy of the processed
            //else it will lose elements from backtrack.
            return lists;
        }
        List<List<Integer>> ans = new ArrayList<>();
        int ele = unprocessed.get(index);
        int n = processed.size();
        for (int i = 0; i <= n; i++) {
            processed.add(i, ele);//insert at i
            ans.addAll(permuteArrRec(processed, unprocessed, index + 1));
            processed.remove(i);//backtrack
        }
        return ans;
    }

    public static int countPermuteStrRec(StringBuilder processed, String unprocessed, int index) {
        if(unprocessed.length() <= index) {
            return 1;
        }
        int count = 0;
        char ch = unprocessed.charAt(index);
        int n = processed.length();
        for (int i = 0; i <= n; i++) {
            processed.insert(i, ch);//insert at i
            count += countPermuteStrRec(processed, unprocessed, index + 1);
            //remenber same processed object is passed to future recursion, they will mutate ur builder,
            //remove your change when u are done with your call.
            processed.deleteCharAt(i);//backtrack
        }
        return count;
    }
}
