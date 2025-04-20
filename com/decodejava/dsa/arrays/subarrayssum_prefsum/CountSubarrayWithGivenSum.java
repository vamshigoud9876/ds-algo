package com.decodejava.dsa.arrays.subarrayssum_prefsum;

import java.util.HashMap;

public class CountSubarrayWithGivenSum {
    public static int subarraySum(int[] nums, int k) {
        return optimalApproach(nums, k);
    }

    /**
     * Time: O(n)
     * Space:O(n)
     */
    private static int optimalApproach(int[] nums, int k) {
        /**
         *  Earlier when we wanted to know the longest length of the substring with given sum.,
         *
         *  - when we encountered a situations with the prefixSum being encountered twice or more we did not update the map.
         *  - Since, we wanted the max length.
         *                                               0 1 2 3 4 5 6
         *          ie., examples like          eg.,1:   1 1 1 0 0 3 5   k = 3
         *                                                   ^ ^ ^
         *                                         PrefSum   3,3,3      Now when we try to compute subarray at index 5,
         *                                                                then we try to find prefSum - k at 5 => 6 - 3 = 3
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefSum = 0, count = 0;
        for (int ele : nums) {
            prefSum += ele;
            if (prefSum == k)
                count++;
            if (map.containsKey(prefSum - k))
                count += map.get(prefSum - k);
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }
        return count;
    }
}
