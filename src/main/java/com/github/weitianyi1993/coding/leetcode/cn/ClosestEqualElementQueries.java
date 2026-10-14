package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestEqualElementQueries {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int n = nums.length;
        for (List<Integer> p : indices.values()) {
            p.add(0, p.get(p.size() - 1) - n);
            p.add(p.get(1) + n);
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int i : queries) {
            List<Integer> p = indices.get(nums[i]);

            if (p.size() == 3) ans.add(-1);
            else {
                int j = Collections.binarySearch(p, i);
                ans.add(Math.min(i - p.get(j - 1), p.get(j + 1) - i));
            }
        }
        return ans;
    }
}
