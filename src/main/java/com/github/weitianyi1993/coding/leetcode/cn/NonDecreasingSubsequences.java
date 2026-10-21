package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        if (list.size() >= 2) res.add(new ArrayList<>(list));

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (list.size() >= 1 && nums[i] < list.get(list.size() - 1)) continue;
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            list.add(nums[i]);
            backtrack(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
