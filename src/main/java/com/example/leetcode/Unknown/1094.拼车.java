package com.example.leetcode.Unknown;
/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] sum = new int[1001];
        for (int[] trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                sum[i] = sum[i] + trip[0];
                if (sum[i] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
