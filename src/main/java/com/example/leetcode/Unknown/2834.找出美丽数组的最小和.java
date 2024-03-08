/*
 * @lc app=leetcode.cn id=2834 lang=java
 *
 * [2834] 找出美丽数组的最小和
 */

// @lc code=start
class Solution {
    public int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            // 最小和为1，2，3，。。。n
            return (int) ((long) (1 + n) * n / 2 % MOD);
        }

        // 最小和为1，2，3.。。target/2, target, target+1...target+(n-m)
        return (int) (((long) (1 + m) * m / 2 +
                ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }
}
// @lc code=end
