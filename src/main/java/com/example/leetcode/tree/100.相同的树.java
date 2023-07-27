/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;



// import com.example.leetcode.base.TreeNode;

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
    boolean res = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return res;
    }

    public void traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null && res) {
            return;
        }
        if (p == null || q == null) {
            res = false;
            return;
        }
        if(p.val != q.val){
            res = false;
            return;
        }
        traverse(p.left, q.left);
        traverse(p.right, q.right);
    }

}
// @lc code=end
