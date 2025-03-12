/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // 备忘录
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        initMemo(m, n);
        return dp(grid, m - 1, n - 1);

    }

    // 初始化备忘录
    private void initMemo(int m, int n) {
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
    }

    private int dp(int[][] grid, int i, int j) {

        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // 防止越界
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        // 自顶向下的使用一个备忘录降低计算量
        if (memo[i][j] != -1) {
            return memo[i][j];
        } else {
            memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
            return memo[i][j];
        }
    }
}
// @lc code=end
