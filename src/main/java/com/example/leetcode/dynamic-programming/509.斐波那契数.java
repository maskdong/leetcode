/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {

        return fibDB(n);
    }

    // 方法一 递归
    public int getFib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return getFib(n - 1) + getFib(n - 2);
    }

    // 方法二 带备忘录的递归
    public int getMemoFib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = getMemoFib(n - 1) + getMemoFib(n - 2);
        memo.put(n, res);
        return res;
    }

    public int fibDB(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
// @lc code=end
