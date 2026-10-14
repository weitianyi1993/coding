package com.github.weitianyi1993.coding.leetcode.cn;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        // 寻找最快的那辆车
        int minTime = time[0];
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        // 开区间 (left, right)
        // 0 耗时绝对完不成 totalTrips (invalid 哨兵)
        long left = 0;
        // 即使只让最快的车跑完 totalTrips 趟，耗时也必定足够完成任务 (valid 候选人)
        long right = (long) minTime * totalTrips;

        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (canComplete(time, totalTrips, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean canComplete(int[] time, int totalTrips, long limit) {
        long count = 0;
        for (int i : time) {
            count += limit / i;
        }
        return count >= totalTrips;
    }
}
