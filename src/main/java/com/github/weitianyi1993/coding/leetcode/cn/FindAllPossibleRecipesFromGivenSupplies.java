package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        int[] inorder = new int[recipes.length];
        Map<String, Integer> recipeToIndex = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeToIndex.put(recipes[i], i);
        }

        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String destination = recipes[i];
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                map.computeIfAbsent(ingredients.get(i).get(j), _ -> new HashSet<>()).add(recipes[i]);
                inorder[recipeToIndex.get(destination)]++;
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == 0 && recipeToIndex.containsKey(recipes[i])) {
                queue.offer(recipes[i]);
            }
        }
        for (String s : supplies) queue.offer(s);

        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (recipeToIndex.containsKey(curr)) res.add(curr);

            if (map.containsKey(curr)) {
                for (String s : map.get(curr)) {
                    if (recipeToIndex.containsKey(s)) {
                        int index = recipeToIndex.get(s);
                        inorder[index]--;
                        if (inorder[index] == 0) {
                            queue.offer(s);
                        }
                    }
                }
            }
        }
        return res;
    }
}
