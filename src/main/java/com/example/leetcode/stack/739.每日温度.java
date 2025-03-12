package com.example.leetcode.stack;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // 这里放元素索引，而不是元素
        Stack<Integer> s = new Stack<>();
        /* 单调栈模板 */
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            // 得到索引间距
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            // 将索引入栈，而不是元素
            s.push(i);
        }
        return res;
    }

}
// @lc code=end
