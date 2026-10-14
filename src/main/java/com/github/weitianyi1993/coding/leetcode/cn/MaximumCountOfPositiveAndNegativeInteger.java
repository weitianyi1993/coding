package com.github.weitianyi1993.coding.leetcode.cn;

public class MaximumCountOfPositiveAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        int result = 0;

        // 1. find last index of negative
        int left = -1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        result = Math.max(result, left + 1);

        left = -1;
        right = n;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        result = Math.max(n - right, result);
        return result;
    }
}
