package com.github.weitianyi1993.coding.leetcode.cn;

public class LongestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        int curr = 0;
        int res = 0;
        if (root.left != null && root.val == root.left.val) {
            curr += left;
            res = Math.max(res, left);
        }
        if (root.right != null && root.val == root.right.val) {
            curr += right;
            res = Math.max(res, right);
        }
        max = Math.max(curr, max);
        return res + 1;
    }
}
