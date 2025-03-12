package com.example.leetcode.tree;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

import com.example.leetcode.base.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // 前序遍历序列化
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }

        // 前序遍历
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(",")) {
            nodes.addLast(node);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

         /******前序遍历位置******/
        // 列表最左侧就是根节点
        String rootVal = nodes.removeFirst();
        if (rootVal.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
