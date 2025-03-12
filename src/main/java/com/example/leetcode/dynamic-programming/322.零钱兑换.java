/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    int memo[];

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dp(coins, amount, memo);

        // return coinChangeDP(coins, amount);
    }

    // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
    public int dp(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin, memo);
            // 子问题无解则跳过
            if (subProblem == -1) {
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        memo[amount] = res;
        return res;
    }

    // 方法二，使用从底向上的dp方法
    public int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 给dp数组初始化，值都为amount+1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
// @lc code=end
