package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountBowlSubarrays {
    public long bowlSubarrays(int[] nums) {
        // if there is a bowl array, then the two sides of the bowl must be forming a monotonic stack
        // decreasing stack? should work, when a new member is inserted and decreasing sequence is formed
        Deque<Integer> deque = new ArrayDeque<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] < curr) {
                deque.pollLast();
                if (!deque.isEmpty()) ans++;
            }
            deque.offerLast(i);
        }
        return ans;
    }
}
