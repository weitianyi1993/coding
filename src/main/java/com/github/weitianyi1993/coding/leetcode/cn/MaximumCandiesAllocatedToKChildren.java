package com.github.weitianyi1993.coding.leetcode.cn;

public class MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int i : candies) {
            max = Math.max(max, i);
        }

        int left = 0;
        int right = max + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            long count = calculate(candies, mid);
            if (count >= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private long calculate(int[] candies, int batch) {
        long count = 0;
        for (int i : candies) {
            count += i / batch;
        }
        return count;
    }
}
