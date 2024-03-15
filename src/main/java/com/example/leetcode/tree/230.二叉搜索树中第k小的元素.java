package com.example.leetcode.tree;

import com.example.leetcode.base.TreeNode;

// import com.example.leetcode.base.TreeNode;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    int res = 0;
    int rank = 0;

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
// @lc code=end
