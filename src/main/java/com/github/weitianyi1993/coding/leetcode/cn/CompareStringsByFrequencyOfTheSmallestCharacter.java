package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsArray = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsArray[i] = f(words[i]);
        }
        Arrays.sort(wordsArray);

        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            String s = queries[i];

            int curr = f(s);
            int left = -1, right = wordsArray.length;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (wordsArray[mid] > curr) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            res[i] = wordsArray.length - right;
        }
        return res;
    }

    private int f(String s) {
        char smallest = 'z';
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c != smallest) {
                if (c - 'a' < smallest - 'a') {
                    smallest = c;
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
