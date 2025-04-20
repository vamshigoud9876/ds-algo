package com.decodejava.dsa.arrays.mergesort_problems;

import java.util.ArrayList;
import java.util.List;

public class SmallerAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        Pair[] pairsArr = new Pair[nums.length];
        for(int i = 0; i<nums.length; i++) {
            pairsArr[i] = new Pair(nums[i], i);
        }
        int[] ans = new int[nums.length];
        mergeSort(pairsArr, 0, nums.length - 1, ans);
        List<Integer> n = new ArrayList<>();
        for(int s: ans) {
            n.add(s);
        }
        return n;
    }

    String res = "com/decodejava/dsa/arrays/mergesort_problems/resources/smaller_after_self.png";
    private static void mergeSort(Pair[] arr, int start, int end, int[] ans) {
        if(start == end) return;
        int mid = start + ((end - start) / 2);
        mergeSort(arr, start, mid, ans);
        mergeSort(arr, mid+1, end, ans);
        merge(arr, start, mid, end, ans);
    }

    private static void merge(Pair[] arr, int start, int mid, int end, int[] ans) {
        Pair[] temp = new Pair[end - start + 1];
        int left = start, right = mid + 1, i = 0;
        while(left <= mid && right <= end) {
            if (arr[left].val > arr[right].val) {
                ans[arr[left].ind] += (end - right + 1);
                temp[i++] = arr[left];
                left++;
            } else {
                temp[i++] = arr[right];
                right++;
            }
        }
        while (left <= mid) {
            temp[i++] = arr[left++];
        }
        while (right <= end) {
            temp[i++] = arr[right++];
        }
        i = 0;
        while(i < temp.length) {
            arr[start++] = temp[i++];
        }
    }
    class Pair {
        int val; int ind;
        Pair(int l, int r) {
            val = l; ind = r;
        }
        public String toString() {
            return val +" "+ ind;
        }
    }
}
