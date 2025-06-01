package com.decodejava.dsa.miscelleneous;

import java.util.Arrays;
import java.util.TreeSet;

public class Even {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2, 1, 3, 0})));
    }
    public static int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        TreeSet<Integer> set = new TreeSet<>();
        helper(digits, 0, -1, -1, set);
        int[] ans = new int[set.size()];
        int i = 0;
        for(int num: set) {
            ans[i++] = num;
        }
        return ans;
    }
    public static void helper(int[] nums, int num, int first, int second, TreeSet<Integer> set) {
        if ((int)Math.floor(Math.log10(num) + 1) >= 3) {
            set.add(num);
            return;
        }
        boolean isFirst = first == -1;
        for (int i = 0; i < nums.length; i++) {
            if(isFirst && nums[i] == 0) continue;
            if(first == i || second == i) continue;
            int cur = num * 10;
            cur += nums[i];
            if (isFirst)
                first = i;
             else
                second = i;

            helper(nums, cur, first, second, set);
        }
    }
}
