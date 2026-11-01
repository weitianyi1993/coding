package com.github.weitianyi1993.coding.leetcode.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumBinaryTree {
    // public TreeNode constructMaximumBinaryTree(int[] nums) {
    //     return construct(nums, 0, nums.length - 1);
    // }

    // private TreeNode construct(int[] nums, int start, int end) {
    //     if (start > end) return null;

    //     int max = Integer.MIN_VALUE;
    //     int idx = -1;
    //     for (int i = start; i <= end; i++) {
    //         if (nums[i] > max) {
    //             max = nums[i];
    //             idx = i;
    //         }
    //     }

    //     TreeNode newNode = new TreeNode(max);
    //     newNode.left = construct(nums, start, idx - 1);
    //     newNode.right = construct(nums, idx + 1, end);
    //     return newNode;
    // }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        TreeNode[] nodes = new TreeNode[n];
        TreeNode root = null;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                right[deque.pollLast()] = i;
            }
            if (!deque.isEmpty()) {
                left[i] = deque.peekLast();
            }
            deque.offerLast(i);
            nodes[i] = new TreeNode(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (left[i] == -1 && right[i] == -1) {
                root = nodes[i];
            } else if (right[i] == -1 || right[i] != -1 && left[i] != -1 && nums[left[i]] < nums[right[i]]) {
                nodes[left[i]].right = nodes[i];
            } else {
                nodes[right[i]].left = nodes[i];
            }
        }
        return root;
    }
}
