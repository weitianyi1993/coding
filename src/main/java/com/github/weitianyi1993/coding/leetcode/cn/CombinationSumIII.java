package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int n, int k, int start, int sum) {
        if (list.size() == k) {
            if (sum == n) res.add(new ArrayList<>(list));
            return;
        }

        if (sum > n || start > 9) {
            return;
        }

        backtrack(res, list, n, k, start + 1, sum);

        list.add(start);
        backtrack(res, list, n, k, start + 1, sum + start);
        list.remove(list.size() - 1);
    }
}
