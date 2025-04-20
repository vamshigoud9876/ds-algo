package com.decodejava.dsa.arrays;

import com.decodejava.dsa.arrays._234Sum_2pointer.ThreeSum;
import com.decodejava.dsa.arrays._234Sum_2pointer.TwoSum;
import com.decodejava.dsa.arrays.dutchnationalflag.Sort3Colors;
import com.decodejava.dsa.arrays.mergesubintervals.MergeIntervals;
import com.decodejava.dsa.arrays.subarrayssum_prefsum.CountSubArrEqualXorK;
import com.decodejava.dsa.arrays.subarrayssum_prefsum.MaxLenSubArrSumK;
import com.decodejava.dsa.arrays.subarrayssum_prefsum.kadanes.Kadane_ObtainMaxSumSubArray;
import com.decodejava.dsa.arrays.subarrayssum_prefsum.kadanes.Kadane_ObtainMaxSumSubArrayIndexes;
import com.decodejava.dsa.strings.LongestUniqueSubstring;

import java.util.Arrays;
import java.util.List;

import static com.decodejava.dsa.asserts.AssertUtil.assertValue;

public class ArraysApp {
    public static void main(String[] args) {
        /**
         * Rotate array left by k times
         */
        int[] a = {1, 2, 3, 44, 5, 6, 7, 8, 9};
        RotateLeftOrRight.rotateRight(a, 4);
        System.out.println(Arrays.toString(a));
        RotateLeftOrRight.rotateLeft(a, 4);
        System.out.println(Arrays.toString(a));



        /**
         * find the longest subarray with given sum K
         * https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
         */
        int length1 = MaxLenSubArrSumK.longestSubarray(new int[]{10, 5, 2, 7, 1, -10}, 15);
        assertValue(length1 , 6);
        System.out.println(length1);
        int length2 = MaxLenSubArrSumK.longestSubarray(new int[]{6, -15, -64, 11, -45, 22, -73, -2, 71, 7, 6, -15, -64, 11, -45, 22, -73, -2, 71, 7}, -14);
        assertValue(length2 , 7);
        System.out.println(length2);



        /**
         * Two Sum
         * https://leetcode.com/problems/two-sum/
         */
        int[] twoSumArr = {2,7,11,15};
        boolean hasTwoSum = TwoSum.hasTwoSum(twoSumArr, 9);
        assertValue(hasTwoSum, true);
        int[] pair = TwoSum.twoSum(twoSumArr, 9);
        assertValue(pair[0], 0);
        assertValue(pair[1], 1);



        /**
         * Dutch national flag Algo
         * sort array with only 0, 1 and 2.
         * https://leetcode.com/problems/sort-colors/
         */
        int[] colorsArray = {2};
        Sort3Colors.sort(colorsArray, 1);
        System.out.println(Arrays.toString(colorsArray));

        /**
         * Kadane's Algorithm
         * Obtain Maximum sum subarray
         */
//        int[] maxSumArr = {2, -3, 5, 6, 7, -3};
        int[] maxSumArr = {-2, -3, -5, -6, -7, -3};
        int maxSum = Kadane_ObtainMaxSumSubArray.maxSubArray(maxSumArr);
        System.out.println("Max Sum : " + maxSum);
        int[] indexes = Kadane_ObtainMaxSumSubArrayIndexes.maxSumSubArrInd(maxSumArr);
        System.out.println("Max Sum Indexes : " + Arrays.toString(indexes));


        /**
         * Next Permutation
         */
//        int[] permuteArr = {1, 2, 3};
        int[] permuteArr = {6, 7, 13, 8, 4, 3, 1};
        NextPermutation.nextPermutation(permuteArr);
        System.out.println(Arrays.toString(permuteArr));

        /**
         *lengthOfLongestSubstring
         */
        String uniqSubStrLen = "dvdf";
        int length = LongestUniqueSubstring.lengthOfLongestSubstring(uniqSubStrLen);
        System.out.println(length);


        /**
         * 2149. Rearrange Array Elements by Sign
         * https://leetcode.com/problems/rearrange-array-elements-by-sign/
         */
//        int[] rearrSignArr = {6, 7, 13, -8, -4, -3, -5, -1, 2, 3};
//        int[] rearrSignArr = {-6, 7};
//        int[] rearrSignArr = {28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31};
        int[] rearrSignArr = {28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31};
        int[] ans = RearrangeArrEleBySign.rearrangeArray(rearrSignArr);
        System.out.println("Rearranged by sign " + Arrays.toString(ans));


        /**
         * Array Leaders
         * https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array
         */
        int[] toGetLeadersArr = {16, 16, 5};
        List<Integer> leaders = ArraysLeaders.leaders(toGetLeadersArr);
        System.out.println("Leaders : " + leaders);


        /**
         * 15. 3Sum
         * https://leetcode.com/problems/3sum
         */
        System.out.println(ThreeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));


        /**
         * Count the no.of subarrays having xor equal to given k
         * https://www.naukri.com/code360/problems/count-subarrays-with-given-xor_1115652
         */
        System.out.println(CountSubArrEqualXorK.subarraysXor(List.of(5, 3, 8, 3, 10), 8));

        /**
         *  56. Merge Intervals
         *  https://leetcode.com/problems/merge-intervals/
         */
        int[][] intervalsArr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergedIntervals = MergeIntervals.merge(intervalsArr);
        System.out.println(Arrays.toString(mergedIntervals));


        /**
         * 229. Majority Element II
         * https://leetcode.com/problems/majority-element-ii
         */

    }
}
