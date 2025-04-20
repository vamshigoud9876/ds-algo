package com.decodejava.dsa.sorting;

public class MergeSort implements Sort{

    @Override
    public int[] sort(boolean isAsc, int... arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start, right = mid + 1, i = 0;
        while(left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[i++] = arr[left];
                left++;
            } else {
                temp[i++] = arr[right];
                right++;
            }
        }
        while (left <= mid) {
            temp[i++] = arr[left++];
        }
        while (right <= end) {
            temp[i++] = arr[right++];
        }
        i = 0;
        while(i < temp.length) {
            arr[start++] = temp[i++];
        }
    }
}
