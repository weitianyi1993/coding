package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SplitArrayWithSameAverage {

    private long sum;
    private int n;
    private int mid;

    private Map<Integer, Set<Long>> rightSums;

    public boolean splitArraySameAverage(int[] nums) {
        n = nums.length;
        if (n < 2) return false;

        sum = 0;
        for (int num : nums) sum += num;

        mid = n / 2;
        rightSums = new HashMap<>();

        // boolean possible = false;
        // for (int k = 1; k <= n / 2; k++) {
        //     if (sum * k % n == 0) {
        //         possible = true;
        //         break;
        //     }
        // }
        // if (!possible) return false;
        collectRight(nums, 0, 0, mid);
        return backtrack(nums, 0, 0, 0);
    }

    private void collectRight(int[] nums, long listSum, int count, int index) {
        if (index >= n) {
            rightSums.computeIfAbsent(count, _ -> new HashSet<>()).add(listSum);
            return;
        }

        collectRight(nums, listSum, count, index + 1);
        collectRight(nums, listSum + nums[index], count + 1, index + 1);
    }

    // count
    // index
    // sum
    private boolean backtrack(int[] nums, long listSum,
                    int count, int index) {
        if (index == mid) {
            return valid(listSum, count);
        }

        if (backtrack(nums, listSum, count, index + 1)) return true;
                // 选
        if (backtrack(nums, listSum + nums[index], count + 1, index + 1)) {
            return true;
        }
        return false;

    }

    private boolean valid(long listSum, int count) {
        for (int k = 1; k <= n / 2; k++) {
            if (sum * k  % n != 0) continue;

            int rightCount = k - count;
            if (rightCount < 0 || rightCount > n - mid) continue;

            long targetSum = sum * k / n;
            long neededSum = targetSum - listSum;
            if (rightSums.containsKey(rightCount) && rightSums.get(rightCount).contains(neededSum)) return true;
        }
        return false;
    }
}
