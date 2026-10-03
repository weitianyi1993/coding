package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

/** LeetCode 3649：完美对的数目. */
public class NumberOfPerfectPairs {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] absoluteValues = new long[n];
        for (int i = 0; i < n; i++) {
            absoluteValues[i] = Math.abs((long) nums[i]);
        }
        Arrays.sort(absoluteValues);

        // For each larger absolute value, count earlier values at least half as large.
        long count = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            while (absoluteValues[i] > absoluteValues[left] * 2) {
                left++;
            }
            count += i - left;
        }
        return count;
    }
}
