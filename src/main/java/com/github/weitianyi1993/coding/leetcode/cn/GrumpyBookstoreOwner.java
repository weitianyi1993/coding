package com.github.weitianyi1993.coding.leetcode.cn;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int alreadySatisfied = 0;
        int n = customers.length;

        // 先统计老板本来就不生气时，已经满意的客户。
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                alreadySatisfied += customers[i];
            }
        }

        // 再用定长滑动窗口统计技巧可以“救回”的生气时段客户，取其中最大值。
        int maxSaved = 0;
        int saved = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                saved += customers[i];
            }
            if (i >= minutes - 1) {
                maxSaved = Math.max(maxSaved, saved);
                int leavingIndex = i - minutes + 1;
                if (grumpy[leavingIndex] == 1) {
                    saved -= customers[leavingIndex];
                }
            }
        }

        return alreadySatisfied + maxSaved;
    }
}
