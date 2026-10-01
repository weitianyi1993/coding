package com.github.weitianyi1993.coding.leetcode;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        // Compare all revision numbers; missing revisions are treated as zero.
        for (int i = 0; i < Math.max(parts1.length, parts2.length); i++) {
            int revision1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
            int revision2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;

            if (revision1 < revision2) {
                return -1;
            }
            if (revision1 > revision2) {
                return 1;
            }
        }

        return 0;
    }
}
