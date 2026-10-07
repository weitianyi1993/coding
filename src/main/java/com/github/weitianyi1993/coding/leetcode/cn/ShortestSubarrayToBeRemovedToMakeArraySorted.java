package com.github.weitianyi1993.coding.leetcode.cn;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public int findLengthOfShortestSubarrayLeft(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) right--;
        if (right == 0) return 0;
        int ans = right;
        for (int left = 0; left < n; left++) {
            while (right < n && arr[right] < arr[left]) right++;
            ans = Math.min(ans, right - left - 1);
            if (left == n - 1 || arr[left] > arr[left + 1]) break;
        }
        return ans;
    }
}
