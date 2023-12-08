/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    // sums[i]表示从0到i的nums的和
    // preSum[i] 比sums[i]多一个前缀，即长度+1，preSum[0]=0.
    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        // 重点：preSum[0] = 0，便于计算累加和
        // 计算 nums 的累加和
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end
