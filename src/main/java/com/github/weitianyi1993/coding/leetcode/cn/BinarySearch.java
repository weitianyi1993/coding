package com.github.weitianyi1993.coding.leetcode.cn;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = -1;
        int n = nums.length;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid;
            else right = mid;
        }

        return -1;
    }
}
