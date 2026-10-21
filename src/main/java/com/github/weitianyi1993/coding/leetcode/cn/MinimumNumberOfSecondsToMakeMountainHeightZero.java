package com.github.weitianyi1993.coding.leetcode.cn;

public class MinimumNumberOfSecondsToMakeMountainHeightZero {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int minTime = Integer.MAX_VALUE;
        for (int t : workerTimes) {
            minTime = Math.min(minTime, t);
        }

        long left = 0;
        long right = (long) minTime * mountainHeight * (mountainHeight + 1) / 2;

        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (valid(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean valid(long limit, int height, int[] workerTimes) {
        long count = 0;

        for (int t : workerTimes) {
            long l = 0, r = height + 1L;

            while (l + 1 < r) {
                long m = l + (r - l) / 2;
                if (t * m * (m + 1) / 2 <= limit) {
                    l = m;
                } else {
                    r = m;
                }
            }

            count += l;
            if (count >= height) return true;
        }

        return false;
    }
}
