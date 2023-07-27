/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return res;
    }

    int res = Integer.MIN_VALUE;

    private int getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 只有超过0的才将该加入最大值链条，不然则抛弃，不需要一直到叶子节点。
        int leftMax = Math.max(getMaxSum(root.left), 0);
        int rightMax = Math.max(getMaxSum(root.right), 0);
        // 后续遍历
        int rootMax = leftMax + rightMax + root.val;
        res = Math.max(res, rootMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
// @lc code=end
