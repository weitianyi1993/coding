package com.github.weitianyi1993.coding.leetcode.cn;

public class PartitionArrayIntoTwoEqualProductSubsets {
    long totalProd = 1;
    public boolean checkEqualPartitions(int[] nums, long target) {

        for (int i : nums) totalProd *= i;
        if (target * target != totalProd) return false;
        return backtrack(nums, target, 0, 1, 1);
    }

    private boolean backtrack(int[] nums, long target, int index, long curr, long reverseCurr) {
        if (index >= nums.length) {
            if (curr == target && reverseCurr == target) {
                return true;
            }

            return false;
        }


        if (backtrack(nums, target, index + 1, curr, reverseCurr * nums[index]) ||
        backtrack(nums, target, index + 1, curr * nums[index], reverseCurr)) {
            return true;
        }
        return false;
    }
}
