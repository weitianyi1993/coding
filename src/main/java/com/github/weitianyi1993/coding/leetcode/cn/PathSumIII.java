package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 10, -2, 2, 8, 0
 * [10, 15, 18, 21]
 */
public class PathSumIII {
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(map, root, 0, targetSum);
        return ans;
    }

    private void dfs(Map<Long, Integer> map, TreeNode root, long sum, int targetSum) {
        if (root == null) return;

        if (map.containsKey(sum + root.val - targetSum)) {
            ans += map.get(sum + root.val - targetSum);
        }

        if (!map.containsKey(sum + root.val)) {
            map.put(sum + root.val, 0);
        }
        map.put(sum + root.val, map.get(sum + root.val) + 1);

        dfs(map, root.left, sum + root.val, targetSum);
        dfs(map, root.right, sum + root.val, targetSum);

         map.put(sum + root.val, map.get(sum + root.val) - 1);

    }
}
