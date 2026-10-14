package com.github.weitianyi1993.coding.leetcode.us;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        Queue<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < inDegree.length; course++) {
            if (inDegree[course] == 0) {
                queue.offer(course);
            }
        }

        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            for (int course : graph[current]) {
                inDegree[course]--;
                if (inDegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }

        return completedCourses == n;
    }
}
