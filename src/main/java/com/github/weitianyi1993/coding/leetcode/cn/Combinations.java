package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combineMultipleBranchMethod(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // boolean[] visited = new boolean[n + 1];
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrackMultipleBranchMethod(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (start == n + 1) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        backtrack(res, list, n, k, start + 1);

        list.add(start);
        backtrack(res, list, n, k, start + 1);
        list.remove(list.size() - 1);
    }
}
