package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumTimeToReachDestinationInDirectedGraph {
    public int minTime(int n, int[][] edges) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int start = edges[i][2];
            int end = edges[i][3];
            map.computeIfAbsent(from, _ -> new ArrayList<>()).add(new int[]{to, start, end});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]); // time, index
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int d = p[0], index = p[1];
            if (index == n - 1) return d;
            if (map.containsKey(index)) {
                for (int[] neigh : map.get(index)) {
                    int neighbor = neigh[0];
                    int start = neigh[1];
                    int end = neigh[2];
                    if (d > end) continue;
                    if (dis[neighbor] > Math.max(d + 1, start + 1)) {
                        dis[neighbor] = Math.max(d + 1, start + 1);
                        queue.offer(new int[]{Math.max(d + 1, start + 1), neighbor});
                    }
                }
            }
        }
        return -1;
    }
}
