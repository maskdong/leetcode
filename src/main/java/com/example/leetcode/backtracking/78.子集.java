package com.example.leetcode.backtracking;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 前序，每个子节点都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            // // 注意，该start值为i+1，元素不可重复使用，使用后，下面只能从该元素后开始遍历添加
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
// @lc code=end
