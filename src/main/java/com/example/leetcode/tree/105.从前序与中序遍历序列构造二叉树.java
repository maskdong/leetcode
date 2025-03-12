package com.example.leetcode.tree;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return traverse(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /*
     * 定义：前序遍历数组为 preorder[preStart..preEnd]，
     * 中序遍历数组为 inorder[inStart..inEnd]，
     * 构造这个二叉树并返回该二叉树的根节点
     */
    private TreeNode traverse(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int inRootIndex = inorderMap.get(rootVal);

        int leftSize = inRootIndex - inStart;

        // 递归构造左右子树
        TreeNode left = traverse(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, inRootIndex - 1);
        TreeNode right = traverse(preorder, preStart + leftSize + 1, preEnd,
                inorder, inRootIndex + 1, inEnd);

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        root.left = left;
        root.right = right;

        return root;

    }
}
// @lc code=end
