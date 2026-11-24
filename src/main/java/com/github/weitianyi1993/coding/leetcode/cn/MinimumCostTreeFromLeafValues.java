package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        int ans = 0;
        deque.push(Integer.MAX_VALUE);

        for (int num : arr) {
            while (deque.size() > 1 && deque.peek() <= num) {
                ans += deque.poll() * Math.min(num, deque.peek());

            }
            deque.push(num);
        }

        while (deque.size() > 2) {
            ans += deque.poll() * deque.peek();

        }
        return ans;
    }
}
