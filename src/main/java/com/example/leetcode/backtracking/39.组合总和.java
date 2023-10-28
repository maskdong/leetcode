/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] + trackSum > target) {
                continue;
            }

            // 选择
            trackSum = trackSum + candidates[i];
            track.addLast(candidates[i]);

            backtrack(candidates, target, i);

            // 取消选择
            trackSum = trackSum - candidates[i];
            track.removeLast();
        }
    }
}
// @lc code=end
