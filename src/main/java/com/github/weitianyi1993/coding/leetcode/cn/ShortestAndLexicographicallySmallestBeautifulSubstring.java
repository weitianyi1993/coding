package com.github.weitianyi1993.coding.leetcode.cn;

public class ShortestAndLexicographicallySmallestBeautifulSubstring {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int left = 0;
        int n = s.length();
        int countOfOne = 0;

        // 【优化 1】：转为字符数组，避免循环中每次频繁调用 s.charAt() 的方法开销与越界检查
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') countOfOne++;

            while (countOfOne == k) {
                // 【优化 2】：在更新答案前，跳过左侧无用的 '0'
                // 这样能确保当前窗口是以 '1' 开头、以 '1' 结尾的最短形态，消除冗余计算
                while (arr[left] == '0') {
                    left++;
                }

                int curLen = i - left + 1;

                // 【优化 3】：先比较长度剪枝，只有当长度更优，或长度相等且字典序更小时才调用 substring
                // 极大减少了每次循环无脑 new String (substring) 带来的堆内存分配与 GC 压力
                if (ans.equals("") || curLen < ans.length()) {
                    ans = s.substring(left, i + 1);
                } else if (curLen == ans.length()) {
                    String sub = s.substring(left, i + 1);
                    if (sub.compareTo(ans) < 0) {
                        ans = sub;
                    }
                }

                // 移除左侧当前这个 '1'，打破 while 循环继续向右找新窗口
                if (arr[left++] == '1') countOfOne--;
            }
        }
        return ans;
    }
}
