package com.decodejava.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SortApp {
    public static void main(String[] args) {
        BubbleSort bubbleSortAlgo = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSortAlgo.sort(false, 1, 4, 3, 44, 33)));
        System.out.println(Arrays.toString(bubbleSortAlgo.sortOptimal(false, 1, 4, 3, 44, 33)));
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(true, 10, 10, 10)));
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(true, 4255, 4, 4, 33, 35, 42, 44, 441)));
    }
}
