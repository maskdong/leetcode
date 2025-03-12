package com.example.leetcode.tree;
/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

import java.util.HashMap;
import java.util.Map;

import com.example.leetcode.base.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用备忘录避免重复
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 抢：
        int do_value = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢：
        int not_do_value = rob(root.left) + rob(root.right);
        int value = Math.max(do_value, not_do_value);
        memo.put(root, value);
        return value;
    }
}
// @lc code=end
