package com.decodejava.dsa.binarysearch;

public class AllocateBooks {
    public static void main(String[] args) {
        System.out.println(findPages(new int[]{15, 10, 19, 10, 5, 18, 7}, 5));
    }
    public static int findPages(int[] arr, int k) {
        /**
         *
         1ST combination -> st1 -> (12, 34) st2-> (67, 90) = 157 == Max
         2ST combination -> st1 -> (12, 34, 67) = 113 == Max st2-> 90
         3ST combination -> st1 -> (12) st2->  (34, 67, 90) = 191 == Max

         only these combinations are possible

         if we try the possible sums from 1....till sum(arr) then at a particular point the minimum sum
         satisfies the alocation. There By we can find the minimum sum.
         Even we are left the students and we have met our max condition then that could be a possible ans.

         **/

        int start = max(arr), end = sum(arr);
        while (start <= end) {
            int mid = (start + end) / 2;
            int pair[] = allocateBooks(arr, k, mid);
            if(pair[0] > k) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
    private static int[] allocateBooks(int[] arr, int k, int max) {
        int stud = 1;
        int currentPages = 0;
        int val = Integer.MIN_VALUE;
        for(int book : arr) {
            if (currentPages+book <= max) {
                    currentPages+=book;
            } else {
                stud++;
                val = Math.max(val, currentPages);
                currentPages = 0;
                if (currentPages+book <= max) {
                    currentPages+=book;
                }
            }
        }
        return new int[]{stud, val==Integer.MIN_VALUE?sum(arr):val};
    }
    private static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int val : arr) {
            if(max < val) max = val;
        } return max;
    }
    private static int sum(int[] arr) {
        int sum = 0;
        for(int val : arr) {
            sum+=val;
        } return sum;
    }
}
