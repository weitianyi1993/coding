package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int middle = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];
            if (middle != -1 && curr < nums[middle]) return true;

            while (!deque.isEmpty() && nums[deque.peek()] < curr) {
                int j = deque.pop();
                middle = j;
            }
            deque.push(i);
        }
        return false;
    }
}
