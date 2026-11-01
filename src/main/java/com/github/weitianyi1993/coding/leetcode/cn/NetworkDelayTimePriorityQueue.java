package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTimePriorityQueue {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] g = new ArrayList[n]; // 邻接表
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] t : times) {
            g[t[0] - 1].add(new int[]{t[1] - 1, t[2]});
        }

        int maxDis = 0;
        int left = n; // 未确定最短路的节点个数
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, k - 1});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int dx = p[0];
            int x = p[1];
            if (dx > dis[x]) { // x 之前出堆过
                continue;
            }
            maxDis = dx; // 求出的最短路会越来越大
            left--;
            for (int[] e : g[x]) {
                int y = e[0];
                int newDis = dx + e[1];
                if (newDis < dis[y]) {
                    dis[y] = newDis; // 更新 x 的邻居的最短路
                    pq.offer(new int[]{newDis, y});
                }
            }
        }
        return left == 0 ? maxDis : -1;
    }
}
