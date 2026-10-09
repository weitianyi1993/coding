package com.github.weitianyi1993.coding.leetcode.cn;

public class MakeStringASubsequenceUsingCyclicIncrements {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.length() < str2.length()) return false;

        int j = 0;
        for (int i = 0; i < str1.length(); i++) {
            char b = str1.charAt(i);
            char c = b == 'z' ? 'a' : (char) (str1.charAt(i) + 1);
            if (b == str2.charAt(j) || c == str2.charAt(j)) {
                j++;
                if (j == str2.length()) return true;
            }
        }
        return false;
    }
}
