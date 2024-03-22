package com.example.leetcode.Unknown;

/*
 * @lc app=leetcode.cn id=700 lang=java
 *
 * [700] 二叉搜索树中的搜索
 */

// @lc code=start

import com.example.leetcode.base.TreeNode;

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
    public TreeNode searchBST(TreeNode root, int val) {
        return traverse(root, val);
    }

    private TreeNode traverse(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (target < root.val) {
            return traverse(root.left, target);
        }
        if (target > root.val) {
            return traverse(root.right, target);
        }
        return root;
    }
}
// @lc code=end
