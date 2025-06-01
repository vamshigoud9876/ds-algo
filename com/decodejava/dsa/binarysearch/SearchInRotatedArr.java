package com.decodejava.dsa.binarysearch;

public class SearchInRotatedArr {
    public int search(int[] nums, int target) {
        int peak = findPeak(nums);
        int index = binarySearch(nums, target, 0, peak);
        if(index == -1)
            return binarySearch(nums, target, peak + 1, nums.length - 1);
        return index;
    }

    private int findPeak(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid+1]) return nums[mid];
            else if(nums[start] > nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if(target < nums[mid]) {
                end = mid - 1;
            } else if(target > nums[mid]) {
                start = mid + 1;
            } else return mid;
        }
        return -1;
    }
}
