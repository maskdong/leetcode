package com.example.leetcode.tree;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private List<Integer> res = new ArrayList<>();

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);

        traverse(node.left);
        traverse(node.right);
    }
}
// @lc code=end
