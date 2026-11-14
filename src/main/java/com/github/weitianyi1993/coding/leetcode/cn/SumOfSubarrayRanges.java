package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        long ans = solve(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];

        }
        return ans + solve(nums);
    }

    private long solve(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int curr = nums[i];

            while (!deque.isEmpty() && nums[deque.peek()] <= curr) {
                int x = deque.pop();
                right[x] = i;
                if (!deque.isEmpty()) {
                    left[x] = deque.peek();
                } else {
                    left[x] = -1;
                }
            }
            deque.push(i);
        }

        while (!deque.isEmpty()) {
            int x = deque.pop();
            left[x] = deque.isEmpty() ? -1 : deque.peek();
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (i - left[i]) * (right[i] - i) * nums[i];
        }
        return ans;
    }
}
