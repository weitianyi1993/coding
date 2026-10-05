package com.github.weitianyi1993.coding.leetcode.cn;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        long product = 1;
        int count = 0;

        // Enumerate each right endpoint i; all valid windows ending at i contribute i - left + 1.
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (left <= i && product >= k) {
                product /= nums[left++];
            }
            count += i - left + 1;
        }

        return count;
    }
}
