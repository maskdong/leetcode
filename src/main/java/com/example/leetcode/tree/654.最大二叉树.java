package com.example.leetcode.tree;

/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

     /* 定义：将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
    public TreeNode buildTree(int[] nums,int l,int r) {
        if (l > r) {
            return null;
        }

        // 找到数组中的最大值和对应的索引
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = l; i <=r; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);
        // 递归调用构造左右子树
        root.left = buildTree(nums, l, index-1);
        root.right = buildTree(nums, index+1, r);
        return root;
    }

}
// @lc code=end
