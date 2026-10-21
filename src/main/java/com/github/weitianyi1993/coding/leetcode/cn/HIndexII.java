package com.github.weitianyi1993.coding.leetcode.cn;

public class HIndexII {
    // 这个有点像脑筋急转弯，如果一开始把citations数组当成二分的对象就错了，因为引用数辆跟最终要求的返回的论文数是两个
    // 搜索的对象。真实的搜索对象应该是0-n。
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (citations[n - mid] >= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
