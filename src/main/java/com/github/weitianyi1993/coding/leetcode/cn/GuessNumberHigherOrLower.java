package com.github.weitianyi1993.coding.leetcode.cn;

/* The guess API is defined in the parent class GuessGame.
   int guess(int num); */
abstract class GuessGame {
    protected abstract int guess(int num);
}

public abstract class GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n + 1;
        if (guess(Integer.MAX_VALUE) == 0) return Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) return mid;
            if (guess(mid) == 1) left = mid;
            else right = mid;
        }
        return -1; // not possible
    }
}
