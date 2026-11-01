package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumObstacleRemovalToReachCorner {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 看一下0-1 bfs
    // 那我的理解就是，假设现在我们来了很多1，然后处理1的时候会遇到空格，就从左面进去1，然后也会遇到强，
    // 就会进去很多2，但是下次poll时候这些1还是只会产生和2，只有2开始产生3的时候才需要担心3的问题
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int INF = Integer.MAX_VALUE;
        int[][] dis = new int[m][n];
        for (int[] array : dis) Arrays.fill(array, INF);
        dis[0][0] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        queue.add(new int[]{0, 0, 0});
        while (true) {
            int[] p = queue.poll();
            int d = p[0], i = p[1], j = p[2];

            if (p[0] > dis[i][j]) continue;

            if (i == m - 1 && j == n - 1) return d;

            for (int[] dir : DIRS) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1) {
                    int g = d + grid[x][y];
                    if (dis[x][y] > g) {
                        dis[x][y] = g; // flex
                        queue.offer(new int[]{g, x, y});
                    }
                }
            }
        }
    }
}
