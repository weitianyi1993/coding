package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashMap;
import java.util.Map;

/** LeetCode 3795：不同元素和至少为 K 的最短子数组长度. */
public class ShortestSubarrayWithDistinctSumAtLeastK {
    public int minLength(int[] nums, int k) {
        // Each distinct value contributes to the window sum only once.
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int distinctSum = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int value = nums[right];
            int valueCount = count.getOrDefault(value, 0);
            if (valueCount == 0) {
                distinctSum += value;
            }
            count.put(value, valueCount + 1);

            while (left <= right && distinctSum >= k) {
                minLength = Math.min(minLength, right - left + 1);

                int leftValue = nums[left++];
                int leftCount = count.get(leftValue) - 1;
                count.put(leftValue, leftCount);
                if (leftCount == 0) {
                    distinctSum -= leftValue;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
