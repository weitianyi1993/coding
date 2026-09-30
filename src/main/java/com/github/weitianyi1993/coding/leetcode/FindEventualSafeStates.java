package com.github.weitianyi1993.coding.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodesKahn(int[][] graph) {
        int n = graph.length;
        List<Integer>[] reverseGraph = new ArrayList[n];
        Arrays.setAll(reverseGraph, ignored -> new ArrayList<>());
        int[] outDegree = new int[n];

        for (int from = 0; from < n; from++) {
            outDegree[from] = graph[from].length;
            for (int to : graph[from]) {
                reverseGraph[to].add(from);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int node = 0; node < n; node++) {
            if (outDegree[node] == 0) {
                queue.offer(node);
            }
        }

        boolean[] safe = new boolean[n];
        while (!queue.isEmpty()) {
            int current = queue.poll();
            safe[current] = true;
            for (int predecessor : reverseGraph[current]) {
                if (--outDegree[predecessor] == 0) {
                    queue.offer(predecessor);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            if (safe[node]) {
                result.add(node);
            }
        }
        return result;
    }

    public List<Integer> eventualSafeNodesBooleanCheck(int[][] graph) {
        int n = graph.length;
        // 0 = unknown, 1 = currently visiting, 2 = safe, 3 = unsafe.
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int node = 0; node < n; node++) {
            if (isSafeWithState(graph, node, state)) {
                result.add(node);
            }
        }
        return result;
    }

    private boolean isSafeWithState(int[][] graph, int node, int[] state) {
        if (state[node] == 1 || state[node] == 3) {
            return false;
        }
        if (state[node] == 2) {
            return true;
        }

        state[node] = 1;
        for (int next : graph[node]) {
            if (!isSafeWithState(graph, next, state)) {
                state[node] = 3;
                return false;
            }
        }
        state[node] = 2;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int node = 0; node < n; node++) {
            if (isUnsafeWithColors(graph, node, colors)) {
                continue;
            }
            result.add(node);
        }
        return result;
    }

    private boolean isUnsafeWithColors(int[][] graph, int node, int[] colors) {
        if (colors[node] == 1) {
            return true;
        }
        if (colors[node] == 2) {
            return false;
        }

        colors[node] = 1;
        for (int next : graph[node]) {
            if (isUnsafeWithColors(graph, next, colors)) {
                return true;
            }
        }
        colors[node] = 2;
        return false;
    }
}
