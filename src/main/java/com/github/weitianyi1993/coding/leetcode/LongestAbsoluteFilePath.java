package com.github.weitianyi1993.coding.leetcode;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<Integer> pathLengths = new Stack<>();
        int maxLength = 0;

        for (String entry : input.split("\n")) {
            int level = entry.lastIndexOf('\t') + 1;
            while (!pathLengths.empty() && pathLengths.size() > level) {
                pathLengths.pop();
            }

            int currentLength = (pathLengths.empty() ? 0 : pathLengths.peek())
                    + entry.length() - level + 1;
            pathLengths.push(currentLength);

            if (entry.contains(".")) {
                maxLength = Math.max(maxLength, currentLength - 1);
            }
        }

        return maxLength;
    }
}
