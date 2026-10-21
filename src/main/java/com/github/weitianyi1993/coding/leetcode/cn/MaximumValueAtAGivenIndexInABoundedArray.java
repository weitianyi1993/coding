package com.github.weitianyi1993.coding.leetcode.cn;

public class MaximumValueAtAGivenIndexInABoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        long left = 1;
        long right = maxSum + 1;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;

            if (valid(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (int) left;
    }

    private boolean valid(long max, int n, int index, int maxSum) {
        long leftSum = calc(max - 1, index);
        long rightSum = calc(max - 1, n - index - 1);
        return leftSum + rightSum + max <= maxSum;
    }

    private long calc(long peak, int count) {
        int sum = 0;
        if (peak >= count) {
            return (peak + peak - count + 1) * count / 2;
        } else {
            return (peak + 1) * peak / 2 + count - peak;
        }
    }
}
