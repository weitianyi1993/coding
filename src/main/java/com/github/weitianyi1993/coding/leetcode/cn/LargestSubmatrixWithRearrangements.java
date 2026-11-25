package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] array = new int[n];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 ) array[j] = 1;
                    else {
                        array[j] += 1;
                    }
                } else {
                    array[j] = 0;
                }

            }
            int[] copiedArray = Arrays.copyOf(array, array.length);
            Arrays.sort(copiedArray);
            ans = Math.max(ans, calculate(copiedArray));
        }
        return ans;
    }

    private int calculate(int[] array) {
        //Deque<Integer> deque = new ArrayDeque<>();
        //deque.push(-1);
        // int ans = 0;
        // for (int i = 0; i <= array.length; i++) {
        //     int curr = i == array.length ? 0 : array[i];
        //     while (deque.size() > 1 && curr <= array[deque.peek()]) {
        //         int index = deque.poll();
        //         ans = Math.max(ans, (i - deque.peek() - 1) * array[index]);
        //     }
        //     deque.push(i);
        // }
        // return ans;
        int ans = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int height = array[i];
            if (i == 0 ||  array[i - 1] < array[i]) {
                ans = Math.max(ans, (array.length - i) * array[i]);
            }
        }
        return ans;
    }
}
