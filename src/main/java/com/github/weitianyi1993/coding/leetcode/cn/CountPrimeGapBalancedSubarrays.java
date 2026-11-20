package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class CountPrimeGapBalancedSubarrays {
    Set<Integer> primes = new HashSet<>();

    public int primeSubarray(int[] nums, int k) {
        initialize();

        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        int left = 0;
        int n = nums.length;
        int res = 0;

        // 记录最近两个 Prime 的 index
        // 用来确定合法 Subarray 左端点的上界
        int lastPrime = -1;
        int secondLastPrime = -1;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];

            // 只有 Prime 才需要更新两个 Monotonic Deque
            if (primes.contains(curr)) {

                // 更新最近两个 Prime 的位置
                secondLastPrime = lastPrime;
                lastPrime = i;

                // Min deque：单调递增
                // 队首是当前 Window 中最小的 Prime
                // 新 Prime 更小时，队尾较大的 Prime 不再有用
                while (!min.isEmpty() &&
                       nums[min.peekLast()] >= curr) {
                    min.pollLast();
                }
                min.offerLast(i);

                // Max deque：单调递减
                // 队首是当前 Window 中最大的 Prime
                while (!max.isEmpty() &&
                       nums[max.peekLast()] <= curr) {
                    max.pollLast();
                }
                max.offerLast(i);
            }

            // 如果最大 Prime - 最小 Prime > k
            // 则不断收缩 Window 的左边界
            while (!min.isEmpty() && !max.isEmpty() &&
                   nums[max.peekFirst()] - nums[min.peekFirst()] > k) {

                left++;

                // 删除已经离开 Window 的 index
                if (!min.isEmpty() && min.peekFirst() < left) {
                    min.pollFirst();
                }
                if (!max.isEmpty() && max.peekFirst() < left) {
                    max.pollFirst();
                }
            }

            // 固定右端点 i：
            //
            // left：满足 maxPrime - minPrime <= k 的最左合法起点
            // secondLastPrime：保证至少两个 Prime 的最右合法起点
            //
            // 所有合法起点：
            // [left, secondLastPrime]
            //
            // 中间即使包含非 Prime，也不影响计数
            //
            // 注意：curr 不是 Prime 时，也必须统计答案
            if (secondLastPrime >= left) {
                res += secondLastPrime - left + 1;
            }
        }

        return res;
    }

    private void initialize() {
        for (int i = 2; i <= 50000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;

        // 因子成对出现，只需检查到 sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
