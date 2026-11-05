package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TheTimeWhenTheNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            map.computeIfAbsent(from, _ -> new HashSet<>()).add(to);
            map.computeIfAbsent(to, k -> new HashSet<>()).add(from);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int idx = 0; idx < size; idx++) {
                int curr = deque.poll();
                if (distance[curr] <= level) continue;
                distance[curr] = level;
                if (map.containsKey(curr)) {
                    for (int neighbor : map.get(curr)) {
                        deque.offer(neighbor);
                    }
                }
            }
            level++;
        }

        int max = 0;
        for (int i = 1; i < patience.length; i++) {
            int dis = distance[i];
            int r = dis * 2;
            int p = patience[i];
            int curr = r + (r - 1) / p * p + 1;
            max = Math.max(max, curr);
        }
        return max;
    }
}
