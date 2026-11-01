package com.github.weitianyi1993.coding.leetcode.cn;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] preorder, int min, int max) {
        if (index < 0 || index >= preorder.length || preorder[index] < min || preorder[index] > max) return null;
        // two things
        // 1. do the dfs for left and right
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left = construct(preorder, min, node.val - 1);
        node.right = construct(preorder, node.val + 1, max);

        return node;
    }
}
