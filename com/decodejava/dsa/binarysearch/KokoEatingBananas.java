package com.decodejava.dsa.binarysearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = max(piles);
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int total = 0;
            for(int i = 0; i < piles.length; i++) {
                total += (int) Math.ceil(piles[i]/(double)mid);
            }
            if (total > h) start = mid +  1;
            else end = mid - 1;
        }
        return start;
    }
    private int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > max) max=piles[i];
        }
        return max;
    }
}
