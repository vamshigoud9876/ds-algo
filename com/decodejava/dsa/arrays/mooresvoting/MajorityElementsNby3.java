package com.decodejava.dsa.arrays.mooresvoting;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementsNby3 {
    public static List<Integer> majorityElement(int[] nums) {
        int major1 = 0, major2 = 0, count1 = 0, count2 = 0;
        for (int item : nums) {
            if(count1 == 0 && item != major2) {
                major1 = item;
                count1 = 1;
            }
            else if(count2 == 0 && item != major1) {
                major2 = item;
                count2 = 1;
            }
            else if(item == major1) count1++;
            else if(item == major2) count2++;
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int ele:nums) {
            if(ele == major1) count1++;
            else if(ele == major2) count2++;
        }
        List<Integer> ans = new ArrayList<>(2);
        if (count1 > nums.length/ 3) ans.add(major1);
        if (count2 > nums.length/ 3) ans.add(major2);
        return ans;
    }
}
