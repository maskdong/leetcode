/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(dp(nums, 0, length - 1), dp(nums, 1, length));
    }

    public int dp(int[] nums, int start, int end) {

        int pre = nums[start];
        int cur = Math.max(nums[start + 1], pre);
        for (int i = start + 2; i < end; i++) {
            int temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }
}
// @lc code=end
