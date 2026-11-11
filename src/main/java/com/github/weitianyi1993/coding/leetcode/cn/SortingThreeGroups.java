package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class SortingThreeGroups {
    public int minimumOperations(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            int index = binarySearch(list, curr);
            if (index == list.size()) {
                list.add(curr);
            } else {
                list.set(index, curr);
            }
        }
        return nums.size() - list.size();
    }

    private int binarySearch(List<Integer> list, int curr) {
        int left = -1;
        int right = list.size();

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > curr) right = mid; // [1,3，1,3]
            else left = mid;
        }
        return right;
    }
}
