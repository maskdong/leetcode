package com.example.leetcode.stack;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start


import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 数组长度加倍模拟环形数组
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }

}
// @lc code=end
