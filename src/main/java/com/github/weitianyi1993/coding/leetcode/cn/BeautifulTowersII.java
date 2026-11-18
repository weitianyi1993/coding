package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BeautifulTowersII {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        int n = maxHeights.size();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = maxHeights.get(i);

        Deque<Integer> deque = new ArrayDeque<>();
        long[] left = new long[n];
        long[] right = new long[n];

        for (int i = 0; i < h.length; i++) {
            int curr = h[i];
            while (!deque.isEmpty() && curr < h[deque.peek()]) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                left[i] = (long)(i + 1) * curr;
            } else {
                left[i] = left[deque.peek()] + (long)(i - deque.peek()) * curr;
            }
            deque.push(i);
        }

        deque.clear();
        for (int i = h.length - 1; i >= 0; i--) {
            int curr = h[i];
            while (!deque.isEmpty() && curr < h[deque.peek()]) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                right[i] = (long)(n - i) * curr;
            } else {
                right[i] = right[deque.peek()] + (long)(deque.peek() - i) * curr;
            }
            deque.push(i);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i] - h[i]);
        }
        return ans;
    }
}
