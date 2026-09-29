package com.github.weitianyi1993.coding.leetcode.cn;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int vowels = 0;
        int maxVowels = 0;

        for (int right = 0; right < s.length(); right++) {
            if (isVowel(s.charAt(right))) {
                vowels++;
            }

            if (right >= k && isVowel(s.charAt(right - k))) {
                vowels--;
            }

            maxVowels = Math.max(maxVowels, vowels);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
