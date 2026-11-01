package com.github.weitianyi1993.coding.leetcode.cn;

public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] >= 1) {
                    sum += findArea(grid, i, j) + 2;
                }
            }
        }
        return sum;
    }

    private int findArea(int[][] grid, int i, int j) {
        int sum = 0;
        int k = grid[i][j];
        if (i == 0 || grid[i - 1][j] < k) sum += i == 0 ? k : k - grid[i - 1][j];
        if (i == grid.length - 1 || grid[i + 1][j] < k) sum += i == grid.length - 1 ? k : k - grid[i + 1][j];
        if (j == 0 || grid[i][j - 1] < k) sum+= j == 0 ? k : k - grid[i][j - 1];
        if (j == grid[0].length - 1 || grid[i][j + 1] < k) sum += j == grid[0].length - 1 ? k : k - grid[i][j + 1];

        return sum;
    }
}
