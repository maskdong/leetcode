/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxLen(root);
        return res;
    }

    int res = 0;

    private int getMaxLen(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLen = getMaxLen(root.left);
        int rightLen = getMaxLen(root.right);
        // 后续遍历，计算每个节点的最长直径
        res = Math.max(res, leftLen + rightLen);
        return 1 + Math.max(leftLen, rightLen);
    }

}
// @lc code=end
