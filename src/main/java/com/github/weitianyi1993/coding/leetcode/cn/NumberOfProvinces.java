package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    class UnionFind {
        int[] father;
        UnionFind(int size) {
            father = new int[size + 1];
            for (int i = 1; i < father.length; i++) {
                father[i] = i;
            }
        }

        void union(int x, int y) { // y is x's father
            int rootX = get(x);
            int rootY = get(y);

            if (rootX == rootY) {
                return;
            }

            father[rootX] = rootY;
        }

        int get(int x) {
            if (father[x] != x) {
                father[x] = get(father[x]);
            }
            return father[x];
        }
    }

    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    if (uf.get(j + 1) == i + 1) continue;
                    uf.union(i + 1, j + 1);
                }
            }
        }

        for (int i = 0; i < isConnected.length; i++) {
            set.add(uf.get(i + 1));
        }
        return set.size();
    }
}
