package com.decodejava.dsa.sorting;


public class QuickSort implements Sort {

    @Override
    public int[] sort(boolean isAsc, int... arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int partition = sortPivot(arr, start, end);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    private int sortPivot(int[] arr, int start, int end) {
        int pivot = start;
        int left = start, right = end;
        // right side all greater elements of pivot. right always points to greater of pivot. if every this is crt
        // then right will fall back in left zone by 1. so that is the swapping point.
        while (left < right) {
            while(arr[left] <= arr[pivot] && left <= end) left++;
            while(arr[pivot] < arr[right] && right >= start) right--;
            if(left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, pivot, right);
        return right;
    }

    private static void swap(int[] nums, int ele1, int ele2) {
        int temp = nums[ele1];
        nums[ele1] = nums[ele2];
        nums[ele2] = temp;
    }
}
