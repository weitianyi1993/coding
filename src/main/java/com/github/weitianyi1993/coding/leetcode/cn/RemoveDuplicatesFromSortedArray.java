package com.github.weitianyi1993.coding.leetcode.cn;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicatesMySolution(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            int curr = nums[j];
            while (j < nums.length && nums[j] == curr) j++;
            nums[i] = nums[j - 1];
            i++;
            if (j == nums.length) break;
        }
        return i;
    }

    public int removeDuplicates(int[] nums) {

        // 1. nums[0] 肯定要保留
        // 2. 快指针遇到断点更新慢指针，慢指针一开始就指向1，因为第0个肯定要保留
        // 最后 k之前是已经保留的，返回k
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
