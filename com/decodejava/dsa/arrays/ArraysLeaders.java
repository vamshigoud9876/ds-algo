package com.decodejava.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.
 */
public class ArraysLeaders {
    public static ArrayList<Integer> leaders(int[] arr) {
        System.out.println("Find Leaders for : " + Arrays.toString(arr));
         bruteForceApproach(arr);
        return optimalApproach(arr);
    }


    private static ArrayList<Integer> bruteForceApproach(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean isMaxFound = false;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[i]) {
                    isMaxFound = true;
                    break;
                }
            }
            if (!isMaxFound) ans.add(arr[i]);
        }
        return ans;
    }

    private static ArrayList<Integer> optimalApproach(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
