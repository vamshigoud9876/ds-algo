package com.decodejava.dsa.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingAndRepeating {
    public static List<Integer> findTwoElement(int[] arr) {
        return markingApproach(arr);
//        return hashingApproach(arr);
    }

    private static ArrayList<Integer> mathSumofnNatural(int[] arr) {
        long n = arr.length;
        long sumOfN = (n * (n + 1)) / 2;
        long sumOfN2 = (n * (n + 1) * (2*n + 1)) / 6;
        long sumOfOrg = 0;
        long sumOfSqOrg = 0;
        for (int i = 0; i < n; i++) {
            sumOfOrg += arr[i];
            sumOfSqOrg += ((long) arr[i] * arr[i]);
        }
        long x = sumOfN - sumOfOrg; // x - y = -2
        long y = sumOfN2 - sumOfSqOrg; // x + y = -1
        y = y / x;
        x = (y + x) / 2;
        y = y - x;
        boolean isYMissing = false;
        for(int ele : arr) {
            if(x == ele) {
                isYMissing = true;
                break;
            }
        }
        ArrayList<Integer> ans= new ArrayList<>(2);
        if (isYMissing) {
            ans.add((int)x);
            ans.add((int)y);
        } else {
            ans.add((int)y);
            ans.add((int)x);
        }
        return ans;
    }

        private static ArrayList<Integer> markingApproach(int[] arr) {
        int repeating = -1, missing = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i]) - 1] < 0) {
                repeating = Math.abs(arr[i]);
                continue;
            }
            arr[Math.abs(arr[i]) - 1] *= -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missing = i+1;
                break;
            }
        }
        ArrayList<Integer> ans= new ArrayList<>(2);
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }

    private static List<Integer> hashingApproach(int[] arr) {
        Set<Integer> hash = new HashSet<>();
        int repeating = -1, missing = -1;
        for(int ele : arr) {
            if(!hash.add(ele)) repeating = ele;
        }
        for (int i = 1; i < arr.length; i++) {
            if(!hash.contains(i)) {
                missing = i;
                break;
            }
        }
        return List.of(repeating, missing);
    }
}
