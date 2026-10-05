package com.github.weitianyi1993.coding.leetcode.cn;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // Treat the retained prefix as a stack: overwrite it with each value that is not val.
        int stackSize = 0;
        for (int num : nums) {
            if (num != val) {
                nums[stackSize++] = num;
            }
        }
        return stackSize;
    }
}
