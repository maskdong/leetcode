/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSumTarget(nums, 3, 0, 0);
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int sz = nums.length;
        if (n < 2 || sz < n) {
            // n小于2或者不满足长度
            return res;
        }

        // 2sum是基础case
        if (n == 2) {
            // 双指针找target值,找到所有可能性
            // 避免重复数字造成的重复结果，需要对重复数字跳过 
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left)
                        lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right)
                        hi--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left)
                        lo++;
                    while (lo < hi && nums[hi] == right)
                        hi--;
                }
            }
        } else {
            // n>2, 递归计算 (n-1)Sum + num[i]
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    // 加上缺的数字，和才是target
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
// @lc code=end
