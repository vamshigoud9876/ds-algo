package com.decodejava.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrEleBySign {

    public static int[] rearrangeArray(int[] nums) {
        System.out.println("Given array to rearrange " + Arrays.toString(nums));
        return optimalApproach(nums);
//        return betterApproach(nums);
//        return inPlaceArrange(nums);
    }

    private static int[] betterApproach(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }
        int i = 0;
        for (; i < Integer.min(pos.size(), neg.size()); i++) {
            ans[i*2] = pos.get(i);
            ans[i*2+1] = neg.get(i);
        }
        while (i < pos.size()) {
            ans[i++] = pos.get(i++);
        }
        while (i < neg.size()) {
            ans[i++] = neg.get(i++);
        }
        return ans;
    }

    private static int[] optimalApproach(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;
        for ( int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                ans[pos] = nums[i];
                pos+=2;
            } else {
                ans[neg] = nums[i];
                neg+=2;
            }
        }
        return ans;
    }

    /**
     * Time : O(2N)
     * Space : O(1)
     *
     * Order not preserved && Works only if the pos count == neg count
     */
    private static int[] inPlaceArrange(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int left = 0, right = 1;
        while(right < nums.length) {
            if (left % 2 == 0 && nums[left] < 0) {
                right = findRightGuy(nums, right, true);
                swap(nums, left, right);
            } else if (left % 2 != 0 && nums[left] > 0) {
                right = findRightGuy(nums, right, false);
                swap(nums, left, right);
            }
            if (left == right) right++;
            left++;
        }
        return nums;
    }

    private static int findRightGuy(int[] nums, int right, boolean isPositive) {
        while ( right < nums.length) {
            if (isPositive && nums[right] > 0) {
                break;
            } else if (!isPositive && nums[right] < 0){
                break;
            } else right++;
        }
        return right;
    }

    private static void swap(int[] nums, int ind1, int ind2) {
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
}
