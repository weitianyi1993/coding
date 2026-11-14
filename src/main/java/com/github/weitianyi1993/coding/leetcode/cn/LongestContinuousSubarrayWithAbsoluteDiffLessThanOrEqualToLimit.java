package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        // 需要一个栈
        // 加入一个新数的时候，需要更新现在的range
        // 并且把不在range里面的元素pop出去
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int max = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            // min deque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[i]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(i);

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[i]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(i);

            while (!minDeque.isEmpty() && !maxDeque.isEmpty() && Math.abs(nums[maxDeque.peek()] - nums[minDeque.peek()]) > limit) {
                if (minDeque.peek() == left) {
                    minDeque.pollFirst();
                }

                if (maxDeque.peek() == left) {
                    maxDeque.pollFirst();
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
