package com.github.weitianyi1993.coding.leetcode.cn;

public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minI = -1, maxI = -1, i0 = -1;
        // minK 最近出现的位置 minI
        // maxK 最近出现的位置 maxI
        // 上一个界限之外的数字是i0
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == minK) {
                minI = i;
            }

            if (x == maxK) {
                maxI = i;
            }

            if (x < minK || x > maxK) {
                i0 = i; // 子数组不能包含 nums[i0]
            }

            if (minI != -1 && maxI != -1) {
                ans += Math.max(Math.min(minI, maxI) - i0, 0);
            }
        }
        return ans;
    }
}
