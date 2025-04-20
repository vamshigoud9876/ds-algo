package com.decodejava.dsa.arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        System.out.println("Given Array : " + Arrays.toString(nums));
        optimalApproach(nums);
    }

    /**
     * Time : O(N)
     * Space: O(1)
     */
    private static void optimalApproach(int[] nums) {
        /**
         *
         * Problem : [1, 2, 3] next permutation [1, 3, 2]. i.e., among all the possible permutations the sort and obtain the next
         * permutation.
         * eg2: [3, 2, 1] this is the last permutation when sorted all permutation. So return the first permutation [1, 2, 3]
         *
         * Observations:
         *     - We need to maintain the largest prefix match since the next permutation would be the closest value greater than the
         *       given combination array.
         *
         *     - Also, find as such element from the right(Since point 1 above), who has any element greater than it.
         *
         *     - Now find the closest element from right greater than point found above.
         *
         *     - Now swap both the point the closest ele. Then reverse the elements next to point because the next permutation should
         *       be as close as possible to given arr.
         *
         *
         *  ->     e.g. = [6, 7, 13, 8, 4, 3, 1]
         *
         *
         *                                                              13 -
         *  Here 7 has 8 and 13 as it's greatest ele to right     -> 7       8 -> 8 is the closest value greater than 7
         *                                                      6               4
         *                                                                          3
         *                                                                              1
         *
         *   - Now Swap 7 and 8 :
         *                                                              13
         *                                                        -> 8      7 <-
         *                                                      6               4
         *                                                                          3
         *                                                                              1
         *  - Now reverse the elements next to point (8)
         *
         *
         *                                                                         13
         *                                                                       7
         *                                                                    4
         *                                                         -> 8    3
         *                                                        6     1
         *
         *   =>     Ans = [6, 8, 1, 3, 4, 7, 13]
         *
         *
         */
        int point = -1;
        for (int i = nums.length - 2; i >= 0; i--) { //find the point to replace
            if (nums[i] < nums[i+1]) {
                point = i;
                break;
            }
        }
        if (point == -1) { // if nothing found i.e, the given array is the last permutation, then return first permutation.
            reverse(nums, 0, nums.length - 1); //[4, 2, 1] => [1, 2, 4]
            return; // Always last permutation will be in decreasing order. since sorted.
        }

        int pair = greaterClosestToRight(nums, point, point + 1, nums.length - 1);
        swap(nums, point, pair);
        reverse(nums, point + 1, nums.length - 1);
    }

    private static int greaterClosestToRight(int[] nums, int point, int start, int end) {
        while (end >= start) {
            if (nums[end] > nums[point]) return end;
            end--;
        }
        return -1;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;end--;
        }
    }

    private static void swap(int[] nums, int ele1, int ele2) {
        int temp = nums[ele1];
        nums[ele1] = nums[ele2];
        nums[ele2] = temp;
    }
}
