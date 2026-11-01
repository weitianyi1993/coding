package com.github.weitianyi1993.coding.leetcode.cn;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    String start = "";
    String dest = "";
    TreeNode startNode = null;
    TreeNode destNode = null;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // 1. 构建root 到两个node的字符串
        // 2. 找到最长的公共字符串并且将之变成U
        dfs(root, startValue, destValue, new StringBuilder());
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (i = 0; i < Math.min(start.length(), dest.length()); i++) {
            if (start.charAt(i) == dest.charAt(i)) continue;
            else break;
        }
        for (int idx = i; idx < start.length(); idx++) sb.append('U');
        sb.append(dest.substring(i));
        return sb.toString();
    }

    private void dfs(TreeNode root, int startValue, int destValue, StringBuilder curr) {
        if (root == null) {
            return;
        }

        if (root.val == startValue) {
            startNode = root;
            start = curr.toString();
        }
        if (root.val == destValue) {
            destNode = root;
            dest= curr.toString();
        }

        if (startNode != null && destNode != null) return;

        curr.append('L');
        dfs(root.left, startValue, destValue, curr);
        curr.deleteCharAt(curr.length() - 1); // 回溯

        // 右子树
        curr.append('R');
        dfs(root.right, startValue, destValue, curr);
        curr.deleteCharAt(curr.length() - 1); // 回溯
    }
}
