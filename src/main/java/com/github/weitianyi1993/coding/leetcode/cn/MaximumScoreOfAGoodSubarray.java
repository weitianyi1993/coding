package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/** LeetCode 1793：好子数组的最大分数. */
public class MaximumScoreOfAGoodSubarray {
    public int maximumScoreMonotonicStack(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Pop >= so the remaining top is the nearest strictly smaller value on the left.
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int[] right = new int[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            // Only consider maximal ranges that contain k; the minimum height is nums[i].
            if (left[i] < k && k < right[i]) {
                answer = Math.max(answer, nums[i] * (right[i] - left[i] - 1));
            }
        }
        return answer;
    }

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k;
        int right = k;
        int minHeight = nums[k];
        int answer = minHeight;

        // Expand toward the larger next value to keep the interval minimum as high as possible.
        for (int step = 0; step < n - 1; step++) {
            if (left == 0 || (right < n - 1 && nums[left - 1] < nums[right + 1])) {
                right++;
                minHeight = Math.min(minHeight, nums[right]);
            } else {
                left--;
                minHeight = Math.min(minHeight, nums[left]);
            }
            answer = Math.max(answer, minHeight * (right - left + 1));
        }
        return answer;
    }
}
