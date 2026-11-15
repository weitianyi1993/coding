package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSubarrayMinProduct {
    private final int MOD = 1000000000 + 7;
    public int maxSumMinProduct(int[] nums) {
        long ans = 0;
        long[] prefixSum = new long[nums.length + 1];
        prefixSum[0] =0 ;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();

        deque.push(-1);
        for (int i = 0; i <= nums.length; i++) {
            int curr = i == nums.length ? 0 : nums[i];
            while (deque.size() > 1 && nums[deque.peek()] >= curr) {
                int index = deque.pop();
                ans = Math.max(ans, (long) nums[index] * (prefixSum[i] - prefixSum[deque.peek() + 1]));
            }
            deque.push(i);
        }
        return (int) (ans % MOD);
    }
}
