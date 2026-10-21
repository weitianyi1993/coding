package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.List;

public class MinimumTimeToBreakLocksI {
    int ans = Integer.MAX_VALUE;
    public int findMinimumTime(List<Integer> strength, int k) {
        int n = strength.size();
        boolean[] visited = new boolean[n];
        backtrack(0, 0, strength.toArray(Integer[]::new), k, visited);
        return ans;
    }

    private void backtrack(int unlocked, int time, Integer[] strength, int k, boolean[] visited) {
        if (time >= ans) {
            return; // 剪枝
        }

        if (unlocked == strength.length) {
            ans = time;
        }

        int x = 1 + unlocked * k;
        for (int i = 0; i < strength.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(unlocked + 1, time + (strength[i] - 1) / x + 1, strength, k, visited);
                visited[i] = false;
            }
        }
    }
}
