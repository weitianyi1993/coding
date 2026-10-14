package com.github.weitianyi1993.coding.leetcode.cn;

public class MinimumInitialStrengthToDefeatAllMonsters {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] bonus = new long[n + 1];
        for (int i = 0; i < boosts.length; i++) {
            bonus[boosts[i][0]] += boosts[i][2];
            bonus[boosts[i][1] + 1] -= boosts[i][2];
        }

        for (int i = 1; i < bonus.length; i++) {
            bonus[i] += bonus[i - 1];
        }

        long left = -1;
        long right = 0;

        for (int i : monsters) right += i;

        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            boolean pass = true;
            long total = mid;
            for (int i = 0; i < monsters.length; i++) {
                if (total + bonus[i] - monsters[i] < 0) {
                    pass = false;
                    break;
                }
                total = Math.max(total - monsters[i], 0);
            }

            if (pass) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
