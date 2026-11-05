package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        int[][] memo = new int[n][2];
        Arrays.fill(res, -1);
        for (int[] arr : memo) Arrays.fill(arr, Integer.MAX_VALUE);
        Map<Integer, Set<Integer>> red = new HashMap<>();
        for (int i = 0; i < redEdges.length; i++) {
            red.computeIfAbsent(redEdges[i][0], _ -> new HashSet<>()).add(redEdges[i][1]);
        }

        Map<Integer, Set<Integer>> blue = new HashMap<>();
        for (int i = 0; i < blueEdges.length; i++) {
            blue.computeIfAbsent(blueEdges[i][0], _ -> new HashSet<>()).add(blueEdges[i][1]);
        }

        dfs(res, memo, red, blue, n, 0, -1, 0);
        return res;
    }

    private void dfs(int[] res, int[][] memo, Map<Integer, Set<Integer>> red, Map<Integer, Set<Integer>> blue, int n, int index, int prev, int distance) {
        // 1. node comes from nowhere
        // 2. node comes from a prev=red (1)
        // 3. node comes from a prev=blue (0)
        // 4. distance carried here is smaller than the previous one res[node]

        if (prev != -1) {
            if (distance >= memo[index][prev]) return;
            memo[index][prev] = distance;
        }

        res[index] = res[index] == -1
        ? distance
        : Math.min(res[index], distance);

        if (prev == -1 || prev == 0) {
            if (red.containsKey(index)) {
                for (int neighbor : red.get(index)) {
                    dfs(res, memo, red, blue, n, neighbor, 1, distance + 1);
                }
            }
        }

        if (prev == -1 || prev == 1) {
            if (blue.containsKey(index)) {
                for (int neighbor : blue.get(index)) {
                    dfs(res, memo, red, blue, n, neighbor, 0, distance + 1);
                }
            }
        }
    }
}
