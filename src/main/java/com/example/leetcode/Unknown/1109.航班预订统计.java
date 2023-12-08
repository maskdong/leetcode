package com.example.leetcode.Unknown;

/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0] - 1; i < booking[1]; i++) {
                res[i] = res[i] + booking[2];
            }
        }
        return res;
    }
}
// @lc code=end
