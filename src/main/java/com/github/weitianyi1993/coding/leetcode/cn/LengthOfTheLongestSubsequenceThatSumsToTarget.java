package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;
import java.util.List;

public class LengthOfTheLongestSubsequenceThatSumsToTarget {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Integer[] a = nums.toArray(Integer[]::new); // 转成数组处理，更快
        int n = a.length;
        int[][] memo = new int[n][target + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }

        int ans = dfs(n - 1, target, a, memo);
        return ans > 0 ? ans : -1;
    }

    private int dfs(int i, int j, Integer[] nums, int[][] memo) {
        if (i < 0) {
            return j == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }

        int res = dfs(i - 1, j, nums, memo); // 不选 nums[i]
        if (j >= nums[i]) {
            res = Math.max(res, dfs(i - 1, j - nums[i], nums, memo) + 1); // 选 nums[i]
        }
        return memo[i][j] = res; // 记忆化
    }
}
