package com.decodejava.dsa.arrays.mooresvoting;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementNby2 {
    public int majorityElement(int[] nums) {
//        return hashingCount(nums);
        return mooresVotingAlgo(nums);
    }

    private static int mooresVotingAlgo(int[] nums) {
        //Works only if the list contains majority element more than n/2 else doesn't return the max occurance element.
        //Basically we are trying to cancel out the majority element with the non-majority elements.
        int count = 0, ele = -1;
        for (int num : nums) {
            if (count == 0) {
                ele = num;
                count = 1;
            }
            else if (ele == num) count++;
            else if (ele != num) count--;
        }
        return ele;
    }

    private static int hashingCount(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() > nums.length / 2)
                return entry.getKey();
        }
        return -1;
    }
}
