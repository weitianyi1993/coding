package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashSet;
import java.util.Set;

public class DistinctPointsReachableAfterSubstringRemoval {
    public int distinctPoints(String s, int k) {
        Set<Long> set = new HashSet<>(); // 用long来存储，GC压力小很多
        int x = 0;
        int y = 0;
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == 'U') y++;
            else if (c == 'D') y--;
            else if (c == 'L') x--;
            else x++;
        }

        // calculate the moving delta
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == 'U') y--;
            else if (c == 'D') y++;
            else if (c == 'L') x++;
            else x--;
            if (i < k - 1) {
                continue;
            }
            set.add(toString(x, y, array.length));
            char ch = array[i - k + 1];
            if (ch == 'U') y++;
            else if (ch == 'D') y--;
            else if (ch == 'L') x--;
            else x++;
        }
        return set.size();
    }

    private Long toString(int x, int y, int n) {
        return (long) ((x + n) << 20 | (y + n));
    }
}
