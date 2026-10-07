package com.github.weitianyi1993.coding.leetcode.cn;

public class MinimumSwapsToMoveZerosToEnd {
    public int minimumSwapsByCounting(int[] nums) {
        int count = 0;
        for (int i : nums) if (i == 0) count++;
        int res = count;
        for (int i = nums.length - 1; i >= nums.length - count; i--) {
            if (nums[i] == 0) res--;
        }
        return res;
    }

    public int minimumSwapsByTwoPointers(int[] nums) {
        int ans = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] != 0) {
                l++;
            } else if (nums[r] == 0) {
                r--;
            } else {
                // 交换 nums[l] 和 nums[r]
                ans++;
                l++;
                r--;
            }
        }
        return ans;
    }
}
