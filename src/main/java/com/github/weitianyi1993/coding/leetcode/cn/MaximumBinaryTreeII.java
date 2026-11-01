package com.github.weitianyi1993.coding.leetcode.cn;

public class MaximumBinaryTreeII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;
        else if (root.val < val) {
            newNode.left = root;
            return newNode;
        } else {
            TreeNode newRightNode = dfs(root.right, val);
            root.right = newRightNode;
            return root;
        }
    }
}
