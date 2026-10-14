package com.github.weitianyi1993.coding.leetcode.cn;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        // [2, 3, 4, 7, 11] -> [1, 1, 1, 3, 6]
        int left = -1;
        int n = arr.length;
        int right = n; // 如果n-1那个数字差的还不够，那么相当于是在n这里了
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 >= k) right = mid;
            else left = mid;
        }
        return right + k;
    }
}
