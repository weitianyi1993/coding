package com.github.weitianyi1993.coding.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.computeIfAbsent(prerequisiteCourse, ignored -> new ArrayList<>()).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            numCourses--;

            for (int course : graph.getOrDefault(current, List.of())) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }

        return numCourses == 0;
    }
}
