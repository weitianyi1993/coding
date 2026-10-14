package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            long curr = spells[i];

            int left = -1, right = potions.length;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (curr * (long) potions[mid] >= success) right = mid;
                else left = mid;
            }
            result[i] = potions.length - right;
        }
        return result;
    }
}
