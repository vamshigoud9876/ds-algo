package com.decodejava.dsa.sorting;

public interface Sort {
    int[] sort(boolean isAsc, int... arr);
    default int[] sortOptimal(boolean isAsc, int... arr) {
        return sort(isAsc, arr);
    }
}
