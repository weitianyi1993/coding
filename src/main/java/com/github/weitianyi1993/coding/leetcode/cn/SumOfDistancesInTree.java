package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfDistancesInTree {
    private List<Integer>[] g;
    private int[] ans;
    private int[] size;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        ans = new int[n];
        size = new int[n];
        dfs(0, -1, 0); // 1. 算ans[0], 2. 算每个子树
        reroot(0, -1);
        return ans;
    }

    private void dfs(int x, int fa, int depth) {
        ans[0] += depth;
        size[x] = 1;
        for (int y : g[x]) {
            if (y != fa) {
                dfs(y, x, depth + 1);
                size[x] += size[y];
            }
        }
    }

    private void reroot(int x, int fa) {
        for (int y : g[x]) {
            if (y != fa) {
                ans[y] = ans[x] + g.length - 2 * size[y];
                reroot(y, x);
            }
        }
    }
}
