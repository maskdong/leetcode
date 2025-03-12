/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 利用双指针剔除节点0，slow 结束时为非零的后一位。
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 将后面节点补0
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }

    }
}
// @lc code=end
