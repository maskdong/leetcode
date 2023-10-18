/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList();
    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    private void backtrack(int n, int k, int start) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            // 做选择
            track.addLast(i);

            // 注意，该start值为i+1，元素不可重复使用，使用后，下面只能从该元素后开始遍历添加
            backtrack(n, k, i + 1);

            // 撤销选择
            track.removeLast();
        }
    }
}
// @lc code=end
