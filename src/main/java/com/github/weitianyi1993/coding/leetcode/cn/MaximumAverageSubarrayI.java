package com.github.weitianyi1993.coding.leetcode.cn;

public class MaximumAverageSubarrayI {
    /** Uses a fixed-length sliding window of size k. */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double maxAverage = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k - 1) {
                continue;
            }

            maxAverage = Math.max(maxAverage, sum / (k * 1.0));
            sum -= nums[i - k + 1];
        }

        return maxAverage;
    }
}
