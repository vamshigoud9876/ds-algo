package com.decodejava.dsa.binarysearch;


//1095. Find in Mountain Array
//https://leetcode.com/problems/find-in-mountain-array/

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int index = findTarget(mountainArr, target, 0, peak, true);
        if (index == -1)
            return findTarget(mountainArr, target, peak+1, mountainArr.length()-1, false);
        return index;
    }

    private int findTarget(MountainArray mountainArr, int target, int start, int end, boolean isAsc) {
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if(target < mountainArr.get(mid)) {
                if(isAsc) end = mid - 1;
                else start = mid + 1;
            } else if(target > mountainArr.get(mid)) {
                if(isAsc) start = mid + 1;
                else end = mid - 1;
            } else return mid;
        }
        return -1;
    }

    private int findPeak(MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid+1)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    interface MountainArray {
        public default int get(int index) {return 0;}
        public default int length() {return 0;}
    }
}





