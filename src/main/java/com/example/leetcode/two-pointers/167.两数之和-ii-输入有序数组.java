/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 二分查找 sum 值
        // 左右双指针
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // 题目要求的索引是从 1 开始的
                return new int[] { left + 1, right + 1 };
            }

            if (sum > target) {
                right--; // 让 sum 小一点
            } else {
                left++; // 让 sum 大一点
            }

        }
        return new int[] { -1, -1 };
    }
}
// @lc code=end
