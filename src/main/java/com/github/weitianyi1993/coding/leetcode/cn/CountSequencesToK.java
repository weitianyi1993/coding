package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashMap;
import java.util.Map;

public class CountSequencesToK {

    // 记忆化搜索：用 (i, p, q) 记录搜索状态，缓存结果，避免重复计算。
    private record Args(int i, long p, long q) {}

    public int countSequences(int[] nums, long k) {
        Map<Args, Integer> memo = new HashMap<>();
        return dfs(nums.length - 1, 1, 1, nums, k, memo);
    }

    private int dfs(int i, long p, long q, int[] nums, long k, Map<Args, Integer> memo) {
        if (i < 0) {
            return p % q == 0 && p / q == k ? 1 : 0;
        }

        Args t = new Args(i, p, q);
        if (memo.containsKey(t)) return memo.get(t);

        int res1 = dfs(i - 1, p * nums[i], q, nums, k, memo);
        int res2 = dfs(i - 1, p, q * nums[i], nums, k, memo);
        int res3 = dfs(i - 1, p, q,           nums, k, memo);

        memo.put(t, res1 + res2 + res3);
        return res1 + res2 + res3;
    }
}
