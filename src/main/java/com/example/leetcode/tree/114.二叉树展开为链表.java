package com.example.leetcode.tree;

import com.example.leetcode.base.TreeNode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

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
    public void flatten(TreeNode root) {
        traverse(root);
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);

        root.right = left;
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;

        return root;

    }
}
// @lc code=end
