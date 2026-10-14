package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class FindTheMaximumNumberOfMarkedIndices {
    // 方法1. 二分法
    public int maxNumOfMarkedIndicesBinarySearch(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n / 2 + 1;
        Arrays.sort(nums);
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (valid(mid, nums, n)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left * 2;
    }

    private boolean valid(int k, int[] nums, int n) {
        for (int i = 0; i < k; i++) {
            if (nums[i] * 2 > nums[n - k + i]) return false;
        }
        return true;
    }

    // 双指针
    public int maxNumOfMarkedIndices(int[] nums) {
        int left = 0;
        Arrays.sort(nums);
        for (int right = (nums.length + 1) / 2; right < nums.length; right++) { // 一半，但如果是基数从中点后面那一位开始，因为odd的话中间匹配不上
            int x = nums[right];
            if (nums[right] >= nums[left] * 2) {
                left++;
            }
        }
        return left * 2;
    }
}
