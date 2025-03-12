package com.example.leetcode.string;

/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    Map<Integer, Integer> postMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return traverse(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode traverse(int[] preorder, int preStart, int preEnd,
            int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        // root.left 的值是前序遍历第二个元素
        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的元素区间
        int rootLeftVal = preorder[preStart + 1];
        // leftRootVal 在后序遍历数组中的索引
        int leftRootIndex = postMap.get(rootLeftVal);
        // 左子树的元素个数
        int leftSize = leftRootIndex - postStart + 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        root.left = traverse(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, leftRootIndex);
        root.right = traverse(preorder, preStart + leftSize + 1, preEnd,
                postorder, leftRootIndex + 1, postEnd - 1);

        return root;
    }
}
// @lc code=end
