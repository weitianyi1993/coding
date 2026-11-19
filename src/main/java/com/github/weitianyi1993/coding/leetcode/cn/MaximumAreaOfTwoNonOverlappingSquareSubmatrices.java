package com.github.weitianyi1993.coding.leetcode.cn;

public class MaximumAreaOfTwoNonOverlappingSquareSubmatrices {
    public int maxArea(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1 + (i == 0 ? 0 : matrix[i - 1][j]);
                }
            }
        }

        int left = 0;
        int right = Math.min(m, n) + 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (valid(mid, matrix)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left * left;
    }

    private boolean valid(int k, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int minRow = m, maxRow = -1;
        int minCol = n, maxCol = -1;

        for (int i = k - 1; i < m; i++) {
            int streak = 0;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= k) {
                    streak++;
                } else {
                    streak = 0;
                }

                if (streak >= k) {
                    // Top-left corner of a valid k x k square
                    int row = i - k + 1;
                    int col = j - k + 1;

                    minRow = Math.min(minRow, row);
                    maxRow = Math.max(maxRow, row);
                    minCol = Math.min(minCol, col);
                    maxCol = Math.max(maxCol, col);

                    if (maxRow - minRow >= k ||
                        maxCol - minCol >= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
