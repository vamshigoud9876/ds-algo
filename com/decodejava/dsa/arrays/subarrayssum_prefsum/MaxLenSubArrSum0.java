package com.decodejava.dsa.arrays.subarrayssum_prefsum;

import java.util.HashMap;
import java.util.Map;

public class MaxLenSubArrSum0 {
    public static int maxLen(int[] arr) {
        // If I have already seen my current prefSum in the past then from the next index till my cur index the sum will be 0.
        // So, my task is to find my cur prefSum in the past.

        int max = 0, prefSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];
            if(prefSum == 0)
                max = Integer.max(max, i + 1);
            if (map.containsKey(prefSum))
                max = Integer.max(max, i - map.get(prefSum));
            else
                map.put(prefSum, i);
        }
        return max;
    }
}
