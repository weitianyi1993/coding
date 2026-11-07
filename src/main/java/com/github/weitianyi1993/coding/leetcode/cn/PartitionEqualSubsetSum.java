package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        int n = nums.length;
        int[][] memo = new int[n][sum / 2 + 1];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return dfs( n - 1, sum / 2, memo, nums);
    }

    private boolean dfs(int i, int j, int[][] memo, int[] nums) {
        if (i == -1 && j == 0) {
            return true;
        }

        if (i == -1) {
            return false;
        }

        if (memo[i][j] != -1) return memo[i][j] == 1;
        boolean pass = false;
        if (j < nums[i]) {
            pass = dfs(i - 1, j, memo, nums);
        } else {
            pass = dfs(i - 1, j, memo, nums) || dfs(i - 1, j - nums[i], memo, nums);
        }

        memo[i][j] = pass ? 1: 0;
        return pass;
    }

    public boolean canPartitionDP(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        int s = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][s + 1];

        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j <= s; j++) {
                if (j < x) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] || dp[i][j - x];
                }

            }
        }
        return dp[n][s];
    }
}
