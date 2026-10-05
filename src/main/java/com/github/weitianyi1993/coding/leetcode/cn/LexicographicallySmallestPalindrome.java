package com.github.weitianyi1993.coding.leetcode.cn;

/** LeetCode 2697：字典序最小回文串. */
public class LexicographicallySmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] characters = s.toCharArray();

        while (left < right) {
            char leftChar = characters[left];
            char rightChar = characters[right];
            if (leftChar < rightChar) {
                characters[right] = leftChar;
            } else if (leftChar > rightChar) {
                characters[left] = rightChar;
            }
            left++;
            right--;
        }

        return new String(characters);
    }
}
