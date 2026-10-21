package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partitionOption1(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        backtrack(res, list, s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> list, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String curr = s.substring(start, i);
            if (isPalindrome(curr)) {
                list.add(curr);
                backtrack(res, list, s, i);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        backtrack(res, list, s, 0, 0); // 1 是第一个分割位置的下标，也符合substring传参的逻辑
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> list, String s, int start, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 不选
        if (index < s.length() - 1) backtrack(res, list, s, start, index + 1);

        // 选
        if (isPalindrome(s, start, index)) {
            list.add(s.substring(start, index + 1));
            backtrack(res, list, s, index + 1, index + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
