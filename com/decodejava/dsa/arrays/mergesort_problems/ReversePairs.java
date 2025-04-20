package com.decodejava.dsa.arrays.mergesort_problems;

class ReversePairs {

    public int reversePairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }


    private static int mergeSort(int[] arr, int start, int end) {
        if(start >= end) return 0;
        int mid = start + ((end - start) / 2);
        int count1 = mergeSort(arr, start, mid);
        int count2 = mergeSort(arr, mid+1, end);
        return merge(arr, start, mid, end, count1 + count2);
    }


    String res = "com/decodejava/dsa/arrays/mergesort_problems/resources/reverse_pairs.png";
    private static int merge(int[] arr, int start, int mid, int end, int count) {
        int[] temp = new int[end - start + 1];
        int left = start, right = mid + 1, i = 0;
        while(left <= mid && right <= end) {
            if(arr[left] > 2L * arr[right]) {
                count += (mid - left + 1);
                right++;
            } else {
                left++;
            }
        }
        left = start; right = mid + 1;
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
        return count;
    }
}

