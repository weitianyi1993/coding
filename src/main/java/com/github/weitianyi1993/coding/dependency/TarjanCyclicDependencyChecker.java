package com.github.weitianyi1993.coding.dependency;

import java.util.*;

// Detects cycles in a directed dependency graph using Tarjan's algorithm.
public class TarjanCyclicDependencyChecker {
    private final Map<String, List<String>> graph;
    private int timestamp;
    private final Map<String, Integer> discoveryTime = new HashMap<>();
    private final Map<String, Integer> lowLink = new HashMap<>();
    private final Deque<String> stack = new ArrayDeque<>();
    private final Set<String> inStack = new HashSet<>();
    private final List<List<String>> cycles = new ArrayList<>();

    public TarjanCyclicDependencyChecker(Map<String, List<String>> graph) {
        this.graph = graph;
    }

    public void check(String dependency) {
        timestamp = 0;
        discoveryTime.clear();
        lowLink.clear();
        stack.clear();
        inStack.clear();
        cycles.clear();
        dfs(dependency);
    }

    private void dfs(String dependency) {
        discoveryTime.put(dependency, timestamp);
        lowLink.put(dependency, timestamp++);
        stack.push(dependency);
        inStack.add(dependency);

        List<String> neighbors = graph.getOrDefault(dependency, Collections.emptyList());
        for (String neighbor : neighbors) {
            if (!discoveryTime.containsKey(neighbor)) {
                dfs(neighbor);
                lowLink.put(dependency, Math.min(lowLink.get(dependency), lowLink.get(neighbor)));
            } else if (inStack.contains(neighbor)) {
                lowLink.put(dependency, Math.min(lowLink.get(dependency), discoveryTime.get(neighbor)));
            }
        }

        if (lowLink.get(dependency).equals(discoveryTime.get(dependency))) {
            List<String> component = new ArrayList<>();
            while (true) {
                String current = stack.pop();
                inStack.remove(current);
                component.add(current);
                if (current.equals(dependency)) {
                    break;
                }
            }

            boolean selfLoop = component.size() == 1 && neighbors.contains(dependency);
            if (component.size() > 1 || selfLoop) {
                cycles.add(component);
                throw new CyclicDependencyException(cycles);
            }
        }
    }
}

