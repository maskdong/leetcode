package com.example.leetcode.array;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || length < n) {
            return res;
        }
        if (n == 2) {
            // 2sum 求和
            int left = start, right = length - 1;
            while (left < right) {
                int leftVal = nums[left];
                int rightVal = nums[right];
                int sum = leftVal + rightVal;
                if (sum < target) {
                    while (left < right && leftVal == nums[left]) {
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && rightVal == nums[right]) {
                        right--;
                    }
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                    while (left < right && leftVal == nums[left]) {
                        left++;
                    }
                    while (left < right && rightVal == nums[right]) {
                        right--;
                    }
                }
            }
        } else {
            for (int i = start; i < length; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
// @lc code=end
