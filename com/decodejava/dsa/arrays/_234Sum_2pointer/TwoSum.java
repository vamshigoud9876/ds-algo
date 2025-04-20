package com.decodejava.dsa.arrays._234Sum_2pointer;

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] arr, int sum) {
        System.out.println(Arrays.toString(arr) + " sum = " + sum);
        int[] optimal = optimal(arr, sum);
        System.out.println("Pair found at = " + Arrays.toString(optimal));
        return optimal;
    }

    private static int[] optimal(int[] arr, int sum) {
        Map<Integer, Integer> hash = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (hash.containsKey(sum - arr[i]))
                return new int[]{hash.get(sum - arr[i]), i};
            hash.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    private static int[] bruteForce(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static boolean hasTwoSum(int[] arr, int sum) {
        System.out.println(Arrays.toString(arr) + " sum = " + sum);
        boolean hasTwoSum = optimalApproach(arr, sum);
        System.out.println("hasTwoSum = " + hasTwoSum);
        return hasTwoSum;
    }

    /**
     * time: O(NlogN)
     * space: O(1)
     */
    private static boolean optimalApproach(int[] arr, int sum) {
        //two pointers approach for which array must be sorted
        Arrays.sort(arr);//O(nlogn)
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == sum) return true;
            else if (arr[left] + arr[right] < sum) left++;
            else right--;
        }
        return false;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private static boolean betterApproach(int[] arr, int sum) {
        Set<Integer> hash = new HashSet<>(arr.length);
        for (int val : arr) {
            if (hash.contains(sum - val))
                return true;
            hash.add(val);
        }
        return false;
    }


    /**
     * Time: O(n^2)
     * Space: O(1)
     */
    private static boolean bruteForceApproach(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum)
                    return true;
            }
        }
        return false;
    }
}
