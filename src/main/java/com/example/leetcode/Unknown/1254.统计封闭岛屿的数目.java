package com.example.leetcode.Unknown;

/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 */

// @lc code=start
class Solution {
    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        // 遍历边缘地区，淹没边缘地区
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        // 寻找封闭岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            // 边界检查
            return;
        }
        if (grid[i][j] == 1) {
            // 如果是海水，返回
            return;
        }

        // 淹没陆地
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
// @lc code=end
