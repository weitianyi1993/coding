package com.github.weitianyi1993.coding.leetcode.cn;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int mx = 0;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            mx = Math.max(mx, i);
        }

        int left = mx - 1;
        int right = sum;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int max) {
        int count = 1; // 这里不是0！
        int curr = 0;
        for (int i : nums) {
            if (curr + i > max) {
                count += 1; // add one partition
                curr = i;

                if (count > k) return false;
            } else {
                curr += i;
            }
        }
        return count <= k;
    }
}
