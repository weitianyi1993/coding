package com.github.weitianyi1993.coding.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        Arrays.setAll(graph, ignored -> new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
            inDegree[to]++;
        }

        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < inDegree.length; course++) {
            if (inDegree[course] == 0) {
                queue.offer(course);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int course : graph[current]) {
                inDegree[course]--;
                if (inDegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }

        if (order.size() != n) {
            return new int[0];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = order.get(i);
        }
        return result;
    }
}
