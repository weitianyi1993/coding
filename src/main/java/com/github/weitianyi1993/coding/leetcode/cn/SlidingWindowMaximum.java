package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        // 预处理 
        for (int i = 0; i < k; i++) {
            int curr = nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] <= curr) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; i++) {
            int curr = nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] <= curr) {
                deque.pollLast();
            }
            deque.offerLast(i);

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();

            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
