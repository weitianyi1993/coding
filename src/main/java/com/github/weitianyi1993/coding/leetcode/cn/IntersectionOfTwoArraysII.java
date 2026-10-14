package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    // 不对，因为匹配的是数组里面的任意元素，所以不可能用双指针因为至少会去match两个array里面的头一个
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     // if (nums1.length > nums2.length) {
    //     //     int[] temp = nums1;
    //     //     nums1 = nums2;
    //     //     nums2 = temp;
    //     // }
    //     List<Integer> list = new ArrayList<>();
    //     int left = 0;
    //     for (int i = 0; i < nums2.length; i++) {
    //         if (nums2[i] == nums1[left]) {
    //             list.add(nums2[i]);
    //             left++;
    //         }
    //         if (left == nums1.length) break;
    //     }
    //
    //     int[] result = new int[list.size()];
    //     int index = 0;
    //     for (int i : list) result[index++] = i;
    //     return result;
    // }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums1) cnt.merge(x, 1, Integer::sum);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int freq = cnt.getOrDefault(nums2[i], 0);
            if (freq > 0) {
                list.add(nums2[i]);
                cnt.put(nums2[i], freq - 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
