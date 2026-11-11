package com.github.weitianyi1993.coding.leetcode.cn;

public class ClimbingStairsII {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = costs[0] + 1;
        if(n == 1) return dp[1];
        dp[2] = Math.min(costs[1] + 4, dp[1] + costs[1] + 1); // costs -> always find costs[i - 1]
        if (n == 2) return dp[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = costs[i - 1] + 1 + dp[i - 1];
            dp[i] = Math.min(dp[i], costs[i - 1] + 4 + dp[i - 2]);
            dp[i] = Math.min(dp[i], costs[i - 1] + 9 + dp[i - 3]);
        }
        return dp[n];
    }
}
