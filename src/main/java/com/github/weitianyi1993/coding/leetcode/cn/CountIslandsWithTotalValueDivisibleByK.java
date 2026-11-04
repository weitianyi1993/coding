package com.github.weitianyi1993.coding.leetcode.cn;

public class CountIslandsWithTotalValueDivisibleByK {
    public int countIslands(int[][] grid, int k) {
        int count = 0 ;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    long total = dfs(grid, i, j);
                    if (total % k == 0) count++;
                }
            }
        }
        return count;
    }

    private long dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;
        long count = grid[i][j];
        grid[i][j] = 0;
        return count + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}
