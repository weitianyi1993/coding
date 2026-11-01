package com.github.weitianyi1993.coding.leetcode.cn;

public class PseudoPalindromicPathsInABinaryTree {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] p = new int[10];
        return dfs(root, p);

    }

    // dfs 返回的是，经过这个root，所有的伪回文数量
    private int dfs(TreeNode root, int[] p) {
        if (root == null) return 0;
        int val = root.val;
        p[val] = p[val] ^ 1;
        int res = 0;

        if (root.left == null && root.right == null) {
            int count = 0;
            for (int i = 1; i <= 9; i++) {
                count += p[i];
            }
            res = count <= 1 ? 1 : 0;
        } else {
            res = dfs(root.left, p) + dfs(root.right, p);
        }
        p[val] = p[val] ^ 1;
        return res;
    }
}
