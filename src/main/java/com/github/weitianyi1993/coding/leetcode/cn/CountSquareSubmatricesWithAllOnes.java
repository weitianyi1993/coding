package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mat = new int[m][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0) {
                        mat[i][j] = 1;
                    } else {
                        mat[i][j] = mat[i - 1][j] + 1;
                    }
                }
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int ans = 0;
        for (int i = 0; i < m; i++) {
             deque.offer(-1);
            for (int j = 0; j <= n; j++) {
                int hr = mat[i][j];
                while (deque.size() > 1 && hr  <= mat[i][deque.peek()]) {
                    int index = deque.poll();
                    int l = deque.peek();
                    int w = j - l - 1;
                    int hl = l == -1 ? 0 : mat[i][l];
                    int lower = Math.max(hr, hl) + 1;
                    int upper = Math.min(mat[i][index], w);
                    if (lower <= upper) {
                        ans += (2 * w - lower - upper + 2)
                            * (upper - lower + 1) / 2;
}
                }
                deque.push(j);
            }
            deque.clear();
        }
        return ans;
    }
}
