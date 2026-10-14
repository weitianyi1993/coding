package com.github.weitianyi1993.coding.leetcode.cn;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // find first bigger or equal number
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid;
        }
        return right;
    }
}
