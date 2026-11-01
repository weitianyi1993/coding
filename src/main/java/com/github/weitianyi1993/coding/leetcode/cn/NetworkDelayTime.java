package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int[] row : g) Arrays.fill(row, INF);
        for (int[] t   : times) g[t[0] - 1][t[1] - 1] = t[2];

        int maxDis = 0;
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[k - 1] = 0;
        boolean[] done = new boolean[n];
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!done[i] && (x < 0 || dis[i] < dis[x])) x = i;
            }

            if (x < 0) return maxDis;
            if (dis[x] == INF) return -1;
            maxDis = dis[x];
            done[x] = true;
            for (int y = 0; y < n; y++) {
                dis[y] = Math.min(dis[y], dis[x] + g[x][y]);
            }
        }


    }
}
