package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int x : nums) {
            int i = binarySearch(g, x);
            if (i < g.size()) {
                g.set(i, x);
            } else {
                g.add(x);            }
        }
        return g.size();
    }

    private int binarySearch(List<Integer> g, int x) {
        int left = -1;
        int right = g.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (g.get(mid) >= x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
