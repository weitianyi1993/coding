package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindLongestSpecialSubstringThatOccursThriceII {

    // 二分法
    public int maximumLengthBinarySerach(String s) {
        int left = 0;
        int right = s.length();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, s)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left == 0 ? -1 : left;
    }

    private boolean check(int length, String s) {
        int[][] len = new int[26][s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                len[s.charAt(i) - 'a'][0] = 1;
                continue;
            }
            if (s.charAt(i) == s.charAt(i - 1)) {
                len[s.charAt(i) - 'a'][i] = len[s.charAt(i) - 'a'][i - 1] + 1;
            } else {
                len[s.charAt(i) - 'a'][i] = 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < len[i].length; j++) {
                if (len[i][j] >= length) count++;
            }
            if (count >= 3) return true;
        }
        return false;
    }

    public int maximumLength(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] list = new ArrayList[26];
        Arrays.setAll(list, _ -> new ArrayList<>());
        int cnt = 0;
        for (int i = 0; i < s.length; i++) {
            cnt++;
            if (i + 1 == s.length || s[i] != s[i + 1]) {
                list[s[i] - 'a'].add(cnt);
                cnt = 0;
            }
        }

        int ans = 0;
        for (List<Integer> a : list) {
            if (a.isEmpty()) continue;
            Collections.sort(a, Collections.reverseOrder());
            a.add(0);
            a.add(0);
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));
        }
        return ans > 0 ? ans : -1;
    }
}
