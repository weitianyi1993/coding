package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class ContinuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int left = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if (nums == null || nums.length == 0) return 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (left <= right && map.lastKey() - map.firstKey() > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public long continuousSubarraysMonotonicQueue(int[] nums) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        long ans = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // maxQ: 保证first那边是最大的，所以新来的打架，已经在的小的都要滚
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= x) {
                maxQ.pollLast();
            }
            maxQ.offerLast(i);

            // minQ: 保证first那边是最小的，所以新来的打架，已经在的大的都要滚
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= x) {
                minQ.pollLast();
            }
            minQ.offerLast(i);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > 2) {
                left++;
                if (minQ.peekFirst() < left) minQ.pollFirst();
                if (maxQ.peekFirst() < left) maxQ.pollFirst();
            }

            ans += i - left + 1;
        }
        return ans;
    }
}
