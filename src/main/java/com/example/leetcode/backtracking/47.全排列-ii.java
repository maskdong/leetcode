package com.example.leetcode.backtracking;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {

        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            // 要点：保证相同元素在排列中的相对位置保持不变。
            // 比如说 nums = [1,2,2']保持排列中 2 一直在 2' 前面。[ [1,2,2'],[2,1,2'],[2,2',1] ]
            // 进一步，如果 nums = [1,2,2',2'']，我只要保证重复元素 2 的相对位置固定，比如说 2 -> 2' -> 2''，也可以得到无重复的全排列结果。
            
            // 当出现重复元素时，比如输入 nums = [1,2,2',2'']，2' 只有在 2 已经被使用的情况下才会被选择，
            // 同理，2'' 只有在 2' 已经被使用的情况下才会被选择，这就保证了相同元素在排列中的相对位置保证固定。
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // 选择
            used[i] = true;
            track.addLast(nums[i]);

            backtrack(nums, used);

            // 取消选择
            used[i] = false;
            track.removeLast();
        }
    }
}
// @lc code=end
