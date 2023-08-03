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

        return getMemoFib(n);
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
}
// @lc code=end
