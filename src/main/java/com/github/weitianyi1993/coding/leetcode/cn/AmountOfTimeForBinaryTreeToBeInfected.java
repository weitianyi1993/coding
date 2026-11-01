package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AmountOfTimeForBinaryTreeToBeInfected {
    TreeNode startNode = null;
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        dfs(map, root, null, start);

        if (root.left == null && root.right == null && root.val == start) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(startNode);

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                visited.add(curr);
                for (TreeNode neighbor : map.get(curr)) {
                    if (!visited.contains(neighbor)) queue.offer(neighbor);
                }
            }
            result++;
        }
        return result - 1;
    }

    private void dfs(Map<TreeNode, Set<TreeNode>> map, TreeNode root, TreeNode fa, int start) {
        if (root == null) return;

        if (root.val == start) startNode = root;
        if (fa != null) {
            map.computeIfAbsent(fa, _ -> new HashSet<>()).add(root);
            map.computeIfAbsent(root, _ -> new HashSet<>()).add(fa);
        }
        dfs(map, root.left, root, start);
        dfs(map, root.right, root, start);
    }
}
