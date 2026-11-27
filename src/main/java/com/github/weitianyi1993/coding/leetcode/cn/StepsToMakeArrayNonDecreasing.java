package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class StepsToMakeArrayNonDecreasing {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int maxTime = 0;
            while (!deque.isEmpty() && nums[deque.peek()] <= curr) {
                int index = deque.poll();
                maxTime = Math.max(maxTime, dp[index]);
            }

            if (deque.isEmpty()) {
                dp[i] = 0;
            } else {
                dp[i] = maxTime + 1;
            }
            deque.push(i);

        }
        int res = 0;
        for (int i : dp) res = Math.max(res, i);
        return res;
    }
}
