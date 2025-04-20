package com.decodejava.dsa.arrays.mergesubintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>(intervals.length);
        int i = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] cur = intervals[0];
        for (int[] interval: intervals) {
            if(interval[0] <= cur[1]) {
                cur[1] = Integer.max(cur[1], interval[1]);
            } else {
                list.add(List.of(cur[0], cur[1]));
                cur = interval;
            }
        }
        list.add(List.of(cur[0], cur[1]));
        int[][] ans = new int[list.size()][2];

        for(List<Integer> item : list) {
           ans[i++] = new int[]{item.get(0), item.get(1)};
        }
        return ans;
    }
}
