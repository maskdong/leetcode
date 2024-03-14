package com.example.leetcode.tree;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    // val -> index
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return traverse(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode traverse(int[] inorder, int inStart, int inEnd,
            int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int inRootIndex = inorderMap.get(rootVal);
        int rightSize = inEnd - inRootIndex;

        TreeNode root = new TreeNode(rootVal);
        root.left = traverse(inorder, inStart, inRootIndex - 1,
                postorder, postStart, postEnd - rightSize - 1);
        root.right = traverse(inorder, inRootIndex + 1, inEnd,
                postorder, postEnd - rightSize, postEnd - 1);

        return root;

    }

}
// @lc code=end
