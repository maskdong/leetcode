/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        // 1. 二叉树遍历方式
        // traverse(root);
        // return res;

        // 2. 分解子问题
        return getMaxDepth(root);
    }

    /*
     * 方法二 分解问题
     */
    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /*
     * 方法一 二叉树遍历
     */
    int res = 0;
    int depth = 0;

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序位置，进入节点时操作
        depth++;
        res = Math.max(res, depth);

        traverse(root.left);
        traverse(root.right);
        // 后续位置，出节点时执行
        depth--;
    }
}
// @lc code=end
