package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathInBinaryMatrix {
    int[][] DIR = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
        if (grid.length == 1 && grid[0].length == 1) return 1;
        queue.offer(new int[]{0, 0});
        grid[0][0] = 2;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int idx = 0; idx < size; idx++) {
                int[] curr = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int x = curr[0] + DIR[i][0];
                    int y = curr[1] + DIR[i][1];
                    if (x == grid.length - 1 && y == grid[0].length - 1) return step + 1;
                    if (x >= 0 && y >= 0 && x <= grid.length - 1 && y <= grid[0].length - 1 && grid[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
