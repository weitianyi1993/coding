package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumTimeToVisitDisappearingNodes {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], _ -> new ArrayList<>()).add(new int[]{edges[i][1], edges[i][2]});
            map.computeIfAbsent(edges[i][1], _ -> new ArrayList<>()).add(new int[]{edges[i][0], edges[i][2]});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[0] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int d = p[0], index = p[1];
            if (d > dis[index]) continue;
            res[index] = d;

            if (map.containsKey(index)) {
                for (int[] arr : map.get(index)) {
                    int idx = arr[0];
                    int distance = arr[1];
                    if (d + distance < disappear[idx] && dis[idx] > d + distance) {
                        dis[idx] = d + distance;
                        queue.offer(new int[]{d + distance, idx});
                    }
                }
            }

        }
        return res;
    }
}
