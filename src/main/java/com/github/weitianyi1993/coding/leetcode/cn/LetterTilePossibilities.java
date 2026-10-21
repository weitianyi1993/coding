package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class LetterTilePossibilities {
    int count = 0;
    public int numTilePossibilities(String tiles) {
        char[] array = tiles.toCharArray();
        Arrays.sort(array);
        boolean[] visited = new boolean[tiles.length()];
        backtrack("", array, visited);
        return count;
    }

    private void backtrack(String curr, char[] array, boolean[] visited) {
        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                if (i == 0 || array[i] != array[i - 1] || visited[i - 1]) {
                    count++;
                    visited[i] = true;
                    backtrack(curr + array[i], array, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
