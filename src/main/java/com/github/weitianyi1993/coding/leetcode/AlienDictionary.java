package com.github.weitianyi1993.coding.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // 入度表要包含所有出现过的字符；没有约束的字符也可以出现在结果中的任意位置。
        for (String word : words) {
            for (char character : word.toCharArray()) {
                graph.putIfAbsent(character, new HashSet<>());
                indegree.putIfAbsent(character, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int commonLength = Math.min(first.length(), second.length());
            int j = 0;

            while (j < commonLength && first.charAt(j) == second.charAt(j)) {
                j++;
            }

            if (j == commonLength) {
                // tricky 前缀情况："app" 在 "apple" 前合法，反过来则非法。
                if (first.length() > second.length()) {
                    return "";
                }
                // "app" 和 "apple" 不会提供 l、e 的顺序信息，它们在结果中的位置不受此比较约束。
                continue;
            }

            char from = first.charAt(j);
            char to = second.charAt(j);
            // 邻接表用 Set 去重；重复边只能给目标字符的入度加一次。
            if (graph.get(from).add(to)) {
                indegree.put(to, indegree.get(to) + 1);
            }
        }

        Queue<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.append(current);
            for (char next : graph.get(current)) {
                int nextIndegree = indegree.get(next) - 1;
                indegree.put(next, nextIndegree);
                if (nextIndegree == 0) {
                    queue.offer(next);
                }
            }
        }

        return order.length() == indegree.size() ? order.toString() : "";
    }
}
