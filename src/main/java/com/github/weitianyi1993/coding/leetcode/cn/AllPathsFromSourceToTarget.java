package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), graph, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int[][] graph, int index) {
        list.add(index);
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < graph[index].length; i++) {
                dfs(res, list, graph, graph[index][i]);
            }
        }
        list.remove(list.size() - 1);
    }
}
