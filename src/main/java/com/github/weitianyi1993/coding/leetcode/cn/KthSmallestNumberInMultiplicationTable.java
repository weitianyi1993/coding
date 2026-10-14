package com.github.weitianyi1993.coding.leetcode.cn;

public class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int left = 0; // not satisfy
        int right = m * n; // satisfy，这里意思是至少有m*n这么多的元素，太多了，我只需要找k个，但还算满足
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, m, n, k)) right = mid;
            else left = mid;
        }
        return right;
    }

    private boolean check(int x, int m, int n, int k) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) cnt += Math.min(x / i, n);
        return cnt >= k;
    }
}
