package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTheNumberOfHousesAtACertainDistanceI {
    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int i = 1; i <= n - 1; i++) {
            neighbors.computeIfAbsent(i, _ -> new ArrayList<>()).add(i + 1);
            neighbors.computeIfAbsent(i + 1, _ -> new ArrayList<>()).add(i);
        }

        if (x != y) {
            neighbors.computeIfAbsent(x, _ -> new ArrayList<>()).add(y);
            neighbors.computeIfAbsent(y, _ -> new ArrayList<>()).add(x);
        }

        for (int i = 1; i <= n; i++) {
            bfs(neighbors, i, n, result);
        }
        return result;
    }

    private void bfs(Map<Integer, List<Integer>> neighbors, int start, int n, int[] result) { // start is 1 indexed
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        visited[start] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int num : neighbors.get(curr)) {
                    if (!visited[num]) {
                        visited[num] = true;
                        result[level]++;
                        queue.offer(num);
                    }
                }
            }
            level++;
        }
    }
}
