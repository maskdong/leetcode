package com.example.leetcode.tree;

/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 从大到小排列BST，需要反着中序遍历

        traverse(root.right);
        sum = sum + root.val;
        root.val = sum;
        traverse(root.left);
    }
}
// @lc code=end
