package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashMap;
import java.util.Map;

/** LeetCode 3679：使库存平衡的最少丢弃次数. */
public class MinimumNumberOfArrivalsToDiscard {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        // 不要因频次超限就移动 left：窗口里的旧物品仍要保留到它自然离开窗口。
        // 当天只决定是否丢弃当前 arrival，并记录丢弃状态，避免它离开窗口时错误减少计数。
        int n = arrivals.length;
        Map<Integer, Integer> count = new HashMap<>();
        boolean[] discarded = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int arrival = arrivals[i];
            int arrivalCount = count.getOrDefault(arrival, 0);

            if (arrivalCount >= m) {
                discarded[i] = true;
                answer++;
            } else {
                count.put(arrival, arrivalCount + 1);
            }

            if (i < w - 1) {
                continue;
            }

            int leavingIndex = i - w + 1;
            if (!discarded[leavingIndex]) {
                int leavingArrival = arrivals[leavingIndex];
                count.put(leavingArrival, count.get(leavingArrival) - 1);
            }
        }

        return answer;
    }
}
