package com.github.weitianyi1993.coding.leetcode.cn;

public class RescheduleMeetingsForMaximumFreeTimeI {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        
        // 把会议的空隙都放进一个数组（要不然也能做就是非常难读）
        // 可以用一个大小为k的滑动窗口，加起来即可
        int n = startTime.length;

        int[] gaps = new int[n+1];
        gaps[0] = startTime[0] - 0;
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int windowSize = k + 1;
        int currentSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currentSum += gaps[i];
        }

        int maxFree = currentSum;
        for (int i = windowSize; i <= n; i++) {
            currentSum += gaps[i] - gaps[i - windowSize];
            maxFree = Math.max(maxFree, currentSum);
        }

        return maxFree;
    }
}
