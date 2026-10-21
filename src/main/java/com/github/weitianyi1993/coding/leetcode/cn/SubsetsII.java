package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), visited, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 不选
        backtrack(res, list, visited, nums, index + 1);

        // 选
        if (index == 0 || nums[index] != nums[index - 1] || (nums[index] == nums[index - 1]) && visited[index - 1]) {
            list.add(nums[index]);
            visited[index] = true;
            backtrack(res, list, visited, nums, index + 1);
            visited[index] = false;
            list.remove(list.size() - 1);
        }
    }
}
