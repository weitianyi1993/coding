package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {

    Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        // 1. find the first element that is equal of larget than left
        int[] res = new int[2];
        if (!map.containsKey(value)) return 0;
        int l = -1, r = map.get(value).size();
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (m < map.get(value).size() && map.get(value).get(m) < left) l = m;
            else r = m;
        }
        res[0] = r;

        l = -1;
        r = map.get(value).size();
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (m < map.get(value).size() && map.get(value).get(m) > right) r = m;
            else l = m;
        }
        res[1] = l;
        return res[1] - res[0] + 1;
    }

}
