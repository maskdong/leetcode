package com.example.leetcode.Unknown;

/*
 * @lc app=leetcode.cn id=2917 lang=java
 *
 * [2917] 找出数组中的 K-or 值
 */

// @lc code=start
class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            // 第i位数字
            int count = 0;
            for (int num : nums) {
                // num >> i：这是一个右移操作，将num的二进制表示向右移动i位。例如，如果num是8（二进制表示为1000），i是2，那么num >>
                // i的结果是2（二进制表示为10）
                // (num >> i) & 1：这是一个位与操作，将num >>
                // i的结果与1进行位与操作。位与操作的规则是，如果两个位都为1，那么结果为1，否则结果为0。因此，(num >> i) & 1的结果将是num >>
                // i的最低位（也就是右边的那一位）。
                if (((num >> i) & 1) != 0) {
                    count++;
                }
            }

            if (count >= k) {
                // 位操作表达式，它的功能是将变量 ans 的第 i 位设置为 1。
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
// @lc code=end
