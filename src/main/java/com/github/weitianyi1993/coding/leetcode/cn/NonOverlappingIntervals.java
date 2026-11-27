package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int total = 0;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ?  a[1] - b[1] : a[0] - b[0] ));

        int[] curr = null;
        for (int i = 0; i < intervals.length; i++) {
            if (curr == null) {
                curr = intervals[i];
            } else {
                if (intervals[i][0] < curr[1]) {
                    curr[1] = Math.min(curr[1], intervals[i][1]);
                    total++;
                } else {
                    curr[1] = Math.max(curr[1], intervals[i][1]);
                }
            }
        }
        return total;
    }
}
