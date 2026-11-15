package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // 找到这个当前index对应的左面最远的比它大于等于的index
        // 
        int n = matrix[0].length;
        int ans = 0;
        int[] array = new int[n + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    array[j] = 0;
                } else {
                    array[j] += 1;
                }
            }
            array[n] = -1;
            ans = Math.max(ans, calculate(array));
        }
        return ans;
    }

    private int calculate(int[] array) {
        int max = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            while (deque.size() > 1 && curr <= array[deque.peek()]) {
                int height = array[deque.pop()];
                int left = deque.peek();
                height = Math.min(height, i - left - 1);
                max = Math.max(max, height * height);
            }
            deque.push(i);
        }
        return max;
    }
}
