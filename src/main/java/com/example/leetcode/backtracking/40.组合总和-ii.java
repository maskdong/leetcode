/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {

        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (trackSum + candidates[i] > target) {
                continue;
            }
            // 选择
            track.addLast(candidates[i]);
            trackSum = trackSum + candidates[i];

            backtrack(candidates, target, i + 1);

            // 取消选择
            track.removeLast();
            trackSum = trackSum - candidates[i];
        }
    }
}
// @lc code=end
