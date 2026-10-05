package com.github.weitianyi1993.coding.leetcode.cn;

/** LeetCode 1871：跳跃游戏 VII. */
public class JumpGameVII {
    // O(n^2): try every destination from each reachable index; this version can time out.
    public boolean canReachTLE(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] reachable = new boolean[n];
        reachable[0] = true;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && reachable[i]) {
                for (int j = i + minJump; j <= Math.min(i + maxJump, n - 1); j++) {
                    if (s.charAt(j) == '0') {
                        reachable[j] = true;
                    }
                }
            }
        }
        return reachable[n - 1];
    }

    // Two pointers avoid scanning destination indexes already considered by earlier positions.
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] reachable = new boolean[n];
        reachable[0] = true;

        int next = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && reachable[i]) {
                for (next = Math.max(next, i + minJump);
                     next <= Math.min(i + maxJump, n - 1);
                     next++) {
                    if (s.charAt(next) == '0') {
                        reachable[next] = true;
                    }
                }
            }
        }
        return reachable[n - 1];
    }

    // DP with prefix sums: test whether any reachable index lies in [i - maxJump, i - minJump].
    public boolean canReachDP(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] reachable = new int[n];
        int[] prefixSum = new int[n + 1];
        reachable[0] = 1;
        prefixSum[1] = 1;

        for (int i = 1; i < n; i++) {
            if (i >= minJump && s.charAt(i) == '0'
                    && prefixSum[i - minJump + 1] > prefixSum[Math.max(0, i - maxJump)]) {
                reachable[i] = 1;
            }
            prefixSum[i + 1] = prefixSum[i] + reachable[i];
        }
        return reachable[n - 1] == 1;
    }

    // The prefix sum itself is enough; no separate reachable array is needed.
    public boolean canReachDP2(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] prefixSum = new int[n + 1];
        prefixSum[1] = 1;

        for (int i = 1; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i];
            if (i >= minJump && s.charAt(i) == '0'
                    && prefixSum[i - minJump + 1] > prefixSum[Math.max(0, i - maxJump)]) {
                prefixSum[i + 1]++;
            }
        }
        return prefixSum[n] - prefixSum[n - 1] == 1;
    }

    // Difference array tracks how many reachable jump ranges cover each index.
    public boolean canReachDifference(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] reachable = new boolean[n];
        int[] difference = new int[n + 1];
        reachable[0] = true;
        int cover = 0;

        for (int i = 0; i < n; i++) {
            cover += difference[i];
            if (i > 0 && s.charAt(i) == '0' && cover > 0) {
                reachable[i] = true;
            }

            if (s.charAt(i) == '0' && reachable[i]) {
                int left = i + minJump;
                int right = Math.min(i + maxJump, n - 1);
                if (left < n) {
                    difference[left]++;
                    difference[right + 1]--;
                }
            }
        }
        return reachable[n - 1];
    }
}
