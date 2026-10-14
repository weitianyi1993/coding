package com.github.weitianyi1993.coding.leetcode.cn;

public class SqrtX {
    private static final int SQRT_INT_MAX = 46340; // sqrt(Integer.MAX_VALUE)

    public int mySqrt(int x) {
        // 开区间 (left, right)
        int left = 0;
        int right = Math.min(x, SQRT_INT_MAX) + 1;
        while (left + 1 < right) { // 开区间不为空
            // 循环不变量：left^2 <= x
            // 循环不变量：right^2 > x
            int m = (left + right) >>> 1;
            if (m * m <= x) {
                left = m;
            } else {
                right = m;
            }
        }
        // 循环结束时 left+1 == right
        // 此时 left^2 <= x 且 right^2 > x
        // 所以 left 最大的满足 m^2 <= x 的数
        return left;
    }
}
