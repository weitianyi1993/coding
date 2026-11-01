package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, new ArrayList<>(), root, targetSum, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, TreeNode root, int targetSum, int curr) {
        if (root == null) return;
        if (root.left == null && root.right == null && targetSum == curr + root.val) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        if (root.left == null && root.right == null) return;

        list.add(root.val);
        dfs(res, list, root.left, targetSum, curr + root.val);
        list.remove(list.size() - 1);

        list.add(root.val);
        dfs(res, list, root.right, targetSum, curr + root.val);
        list.remove(list.size() - 1);
    }
}
