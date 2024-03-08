package com.example.leetcode.stack;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElement = nextGreaterElement(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nextGreaterElement[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    private int[] nextGreaterElement(int[] num) {
        int n = num.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着遍历，排列出单调递增
        for (int i = n - 1; i >= 0; i--) {
            // 判断大小
            while (!s.isEmpty() && s.peek() <= num[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(num[i]);
        }
        return res;
    }
}
// @lc code=end
