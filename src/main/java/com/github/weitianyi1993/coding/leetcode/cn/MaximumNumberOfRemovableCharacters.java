package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfRemovableCharacters {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n = removable.length;
        int left = 0; // valid
        int right = n + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(s, p, mid, removable)) left = mid;
            else right = mid;
        }
        return left;
    }

    private boolean check(String s, String p, int k, int[] removable) {
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>(); // 理论上可以用 removeTime 数组记录每个字符在第几次删除时被移除
        for (int idx = 0; idx < k; idx++) set.add(removable[idx]);
        while (i < s.length() && j < p.length()) {
            if (set.contains(i)) {
                i++;
                continue;
            }

            if (s.charAt(i) != p.charAt(j)) {
                i++;
                continue;
            }

            i++;
            j++;
        }
        return j == p.length();
    }
}
