package com.github.weitianyi1993.coding.leetcode.cn;

public class LowestCommonAncestorOfDeepestLeaves {
    public TreeNode lcaDeepestLeavesBottomUp(TreeNode root) {
        return dfs(root).getValue();
    }

    private Pair<Integer, TreeNode> dfs(TreeNode root) {
        if (root == null) return new Pair<>(0, null); // 我们从下到上，所以null这块定义了最低的深度是0

        Pair<Integer, TreeNode> left = dfs(root.left);
        Pair<Integer, TreeNode> right = dfs(root.right);

        if (left.getKey() < right.getKey()) {
            return new Pair(right.getKey() + 1, right.getValue());
        }

        if (left.getKey() > right.getKey()) {
            return new Pair(left.getKey() + 1, left.getValue());
        }

        return new Pair<>(left.getKey() + 1, root);
    }

    private record Pair<K, V>(K key, V value) {
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    int maxDepth = -1;
    TreeNode candidate = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        find(root, 0);
        return candidate;
    }

    // private int find(TreeNode root, int depth) {
    //     if (root == null) {
    //         maxDepth = Math.max(maxDepth, depth); //(1)
    //         return depth;
    //     }

    //     int maxLeftDepth = find(root.left, depth + 1);
    //     int maxRightDepth = find(root.right, depth + 1);

    //     if (maxLeftDepth == maxDepth && maxRightDepth == maxDepth) {
    //         candidate = root;
    //         // maxDepth = Math.max(maxLeftDepth, maxRightDepth); (2)
    //     }
    //     return Math.max(maxLeftDepth, maxRightDepth);
    // }
    private int find(TreeNode root, int depth) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
            if (depth == maxDepth) {
                candidate = root;
            }
            return depth;
        }

        int maxLeftDepth = find(root.left, depth + 1);
        int maxRightDepth = find(root.right, depth + 1);

        if (maxLeftDepth == maxDepth && maxRightDepth == maxDepth) {
            candidate = root;
        }
        return Math.max(maxLeftDepth, maxRightDepth);
    }
}
