package com.example.leetcode.backtracking;

import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, trace, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    public void backtrack(int[] nums, LinkedList<Integer> trace, boolean[] used) {
        if (trace.size() == nums.length) {
            res.add(new ArrayList<>(trace));
            return;
        }

        for(int i=0; i<nums.length;i++){
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }

            // 选择
            used[i] = true;
            trace.add(nums[i]);
            // 下一层决策
            backtrack(nums, trace, used);
            // 取消选择
            used[i] = false;
            trace.removeLast();
        }
    }
}
// @lc code=end
