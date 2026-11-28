package com.github.weitianyi1993.coding.leetcode.cn;

public class CheckIfAStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;

        boolean valid1 = true;
        boolean valid2 = true;
        int sum = 0;
        for (int i  = 0; i < 26; i++) {
            sum += count[i];
            if (sum > 0) valid1 = false;
            else if (sum < 0) valid2 = false;
        }
        return valid1 || valid2;
    }
}
