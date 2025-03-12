/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0, right = 0;

        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum = sum + nums[right];
            right++;

            while (sum >= target) {
                res = Math.min(res, right - left);
                sum = sum - nums[left];
                left++;
            }

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end
