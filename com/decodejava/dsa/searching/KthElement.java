package com.decodejava.dsa.searching;

public class KthElement {
    public int kthElement(int a[], int b[], int k) {
        // first lets try to pick the k number of elements from both the arrays.
        if(a.length > b.length) return kthElement(b, a, k);
        int start = Integer.max(k-b.length, 0), end = Integer.min(k, a.length);
        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] :  Integer.MIN_VALUE;
            int r1 = (mid1 < a.length) ? a[mid1] : Integer.MAX_VALUE;
            int mid2 = k - mid1;
            int l2 = (mid2 > 0) ? b[mid2 - 1] :  Integer.MIN_VALUE;
            int r2 = (mid2 < b.length) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 > r2) end = mid1 - 1;
            else if (l2 > r1) start = mid1 + 1;
            else {
                return Integer.max(l1, l2);
            }
        }
        return -1;
    }
}
