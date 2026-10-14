package com.github.weitianyi1993.coding.leetcode.cn;

public class ReplaceTheSubstringForBalancedString {
    public int balancedString(String S) {
        char[] s = S.toCharArray();
        int[] cnt = new int['X'];
        for (char c : s) cnt[c]++;
        int n = s.length, m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0; // 已经符合要求啦
        }
        int ans = n;
        int left = 0;
        for (int right = 0; right < s.length; right++) {
            cnt[s[right]]--;
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(right - left + 1, ans);
                cnt[s[left]]++;
                left++;
            }
        }
        return ans;
    }
}
