package com.github.weitianyi1993.coding.leetcode.cn;

public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (i > 0) {
                        matrix[i][j] = matrix[i - 1][j] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += calculateLeft(matrix, i, j);
            }
        }
        return ans;
    }

    private int calculateLeft(int[][] matrix, int i, int j) {
        int curr = matrix[i][j];
        int ans = 0;
        for (int idx = j; idx >= 0; idx--) {
            curr = Math.min(curr, matrix[i][idx]);
            ans += curr;
        }
        return ans;
    }
}
