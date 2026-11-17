package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.List;

public class BeautifulTowersII {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        int n = maxHeights.size();

        for (int peak = 0; peak < n; peak++) {
            long sum = maxHeights.get(peak);
            int height = maxHeights.get(peak);

            for (int i = peak - 1; i >= 0; i--) {
                height = Math.min(height, maxHeights.get(i));
                sum += height;
            }

            height = maxHeights.get(peak);

            for (int i = peak + 1; i < n; i++) {
                height = Math.min(height, maxHeights.get(i));
                sum += height;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
