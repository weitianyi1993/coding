package com.github.weitianyi1993.coding.leetcode.cn;

public class MinimumRemovalsToAchieveTargetXor {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][1 << 14];
        return dfs(nums, memo, n - 1, target, 0);
    }

    private int dfs(int[] nums, Integer[][] memo, int index, int target, int curr) {
        if (index < 0) {
            if (target == curr) {
                return 0;
            }
            return -1;
        }

        if (memo[index][curr] != null) return memo[index][curr];
        int min = Integer.MAX_VALUE;
        int no = dfs(nums, memo, index - 1, target, curr);
        int yes = dfs(nums, memo, index - 1, target , curr ^ nums[index]);
        if (yes != -1 && no != -1) return memo[index][curr] = Math.min(yes, no + 1);
        else if (yes != -1) return memo[index][curr] = yes;
        else if (no != -1) return memo[index][curr] = no + 1;
        return memo[index][curr]=  -1;
    }
}
