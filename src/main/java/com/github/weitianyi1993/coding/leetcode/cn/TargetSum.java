package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class TargetSum {
    // public int findTargetSumWays(int[] nums, int target) {
    //     // p - (s - p) = target
    //     // (target + s) / 2 -> p
    //     int sum = 0;
    //     for (int n : nums) sum += n;
    //     if ((sum + target) % 2 == 1) return 0;
    //     if (sum + target < 0) return 0;
    //     target = (sum + target) / 2;
    //     int[][] memo = new int[nums.length][target + 1]; // from left to including index, numbers of solutions for c
    //     for (int[] array : memo) Arrays.fill(array, -1);
    //     return dfs(nums, memo, target, nums.length - 1);
    // }

    // private int dfs(int[] nums, int[][] memo, int target, int index) {
    //     if (index < 0) {
    //         return target == 0 ? 1 : 0;
    //     }

    //     if (memo[index][target] != -1) return memo[index][target];
    //     int count = 0;
    //     if (target < nums[index]) {
    //         count += dfs(nums, memo, target, index - 1);
    //     } else {
    //         count += dfs(nums, memo, target, index - 1);
    //         count += dfs(nums, memo, target - nums[index], index - 1);
    //     }
    //     memo[index][target] = count;
    //     return count;
    // }
    public int findTargetSumWays(int[] nums, int target) {
        // p - (s - p) = target
        // (target + s) / 2 -> p
        int sum = 0;
        for (int n : nums) sum += n;
        if ((sum + target) % 2 == 1) return 0;
        if (sum + target < 0) return 0;
        target = (sum + target) / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                int count = 0;
                if (j < nums[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] + dp[i][j - nums[i]];
                }
                // if (target < nums[i]) {
                //     count += dfs(nums, memo, target, index - 1);
                // } else {
                //     count += dfs(nums, memo, target, index - 1);
                //     count += dfs(nums, memo, target - nums[index], index - 1);
                // }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
