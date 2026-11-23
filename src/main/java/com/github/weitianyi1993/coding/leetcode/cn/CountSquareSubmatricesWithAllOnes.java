package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int n = matrix[0].length;
        int[] heights = new int[n + 1]; // 末尾多一个 0，理由见我 84 题题解
        int ans = 0;
        for (int[] row : matrix) {
            // 计算底边为 row 的柱子高度
            for (int j = 0; j < n; j++) {
                int x = row[j];
                if (x == 0) {
                    heights[j] = 0; // 柱子高度为 0
                } else {
                    heights[j]++; // 柱子高度加一
                }
            }
            ans += solve(heights);
        }
        return ans;
    }

    private int solve(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 哨兵：在栈中只有一个数的时候，栈顶的「下面那个数」是 -1，对应 left[i] = -1 的情况
        int ans = 0;
        for (int r = 0; r < heights.length; r++) {
            int hr = heights[r];
            while (st.size() > 1 && heights[st.peek()] >= hr) {
                int h = heights[st.pop()]; // 矩形的高
                int l = st.peek(); // 栈顶下面那个数就是 l
                int w = r - l - 1;
                int upper = Math.min(h, w);
                int lower = (l < 0 ? hr : Math.max(heights[l], hr)) + 1;
                if (lower <= upper) {
                    ans += (w * 2 + 2 - lower - upper) * (upper - lower + 1) / 2;
                }
            }
            st.push(r);
        }
        return ans;
    }
}
