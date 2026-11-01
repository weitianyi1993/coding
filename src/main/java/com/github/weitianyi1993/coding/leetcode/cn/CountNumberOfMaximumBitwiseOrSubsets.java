package com.github.weitianyi1993.coding.leetcode.cn;

public class CountNumberOfMaximumBitwiseOrSubsets {
    public int countMaxOrSubsets(int[] nums) {
        int totalOr = 0;
        for (int x : nums) {
            totalOr |= x;
        }

        dfs(0, 0, nums, totalOr);
        return ans;
    }

    private int ans = 0;

    private void dfs(int i, int subsetOr, int[] nums, int totalOr) {
        if (subsetOr == totalOr) {
            ans += 1 << (nums.length - i);
            return;
        }
        if (i == nums.length) {
            return;
        }
        dfs(i + 1, subsetOr, nums, totalOr); // 不选 nums[i]
        dfs(i + 1, subsetOr | nums[i], nums, totalOr); // 选 nums[i]
    }
}
