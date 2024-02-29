/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        int[] dp = new int[n + 2];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // 类似斐波那契数列
        // n阶种类 = n-1阶种类 + n-2阶种类
        // 因为这两种再+1，+2就是目标数量。可以以3阶举例。
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
// @lc code=end
