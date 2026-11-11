package com.github.weitianyi1993.coding.leetcode.cn;

public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i + 1][0] = dp[i][0]+(int) s1.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = dp[0][i]+ (int) s2.charAt(i);
        }

        for (int i = 0;i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + (int)s1.charAt(i), dp[i + 1][j] + (int)s2.charAt(j));
                }
            }
        }
        return dp[m][n];
    }
}
