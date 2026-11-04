package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsFarFromLandAsPossible {
    int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int maxDistance(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    deque.offer(new int[]{i, j});
                }
            }
        }
        if (deque.size() == 0 || deque.size() == grid.length * grid[0].length) return -1;

        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] curr = deque.poll();
                for (int[] dir : DIR) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
                        deque.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
            if (deque.size() == 0) return level;
            level++;
        }

        return -1;
    }
}
