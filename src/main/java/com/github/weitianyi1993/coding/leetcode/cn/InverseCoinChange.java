package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class InverseCoinChange {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        List<Integer> res = new ArrayList<>();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (numWays[i - 1] == f[i]) continue;
            if (numWays[i - 1] - f[i] != 1) return List.of();
            res.add(i);

            for (int j = i; j <= n; j++) {
                f[j] += f[j - i];
            }
        }
        return res;
    }
}
