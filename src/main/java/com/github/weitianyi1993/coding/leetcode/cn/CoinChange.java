package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class CoinChange {
    public int coinChangeDfs(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        if (amount == 0) return 0;
        for (int i : coins) {
            if (i < memo.length) memo[i] = 1;
        }
        return dfs(memo, coins, amount);
    }

    private int dfs(Integer[] memo, int[] coins, int amount) {
        if (memo[amount] != null) return memo[amount];

        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount >= coin) {
                int curr = dfs(memo, coins, amount - coin);
                if (curr != -1) {
                    count = Math.min(count, curr + 1);
                }
            }

        }
        memo[amount] = count == Integer.MAX_VALUE ? -1 :  count;
        return memo[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i : coins) {
            if (i < dp.length) dp[i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                    if (i >= coin) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
