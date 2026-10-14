package com.github.weitianyi1993.coding.leetcode.cn;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        for (int i : weights) max += i;
        int left = 0, right = max;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (calculateDays(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private int calculateDays(int[] weights, int capacity) {
        int count = 0;
        int curr = 0;
        for (int i : weights) {
            if (capacity < i) return Integer.MAX_VALUE;
            if (capacity - curr >= i) {
                curr += i;
            } else {
                count += 1;
                curr = i;
            }
        }
        return curr > 0 ? count + 1 : count;
    }
}
