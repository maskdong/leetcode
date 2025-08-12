/*
 * @lc app=leetcode.cn id=15 lang=java
 * @lcpr version=30202
 *
 * [15] 三数之和
 */

import java.util.*;
import com.example.leetcode.base.*;

public class ThreeSum {

    // @lc code=start
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            Arrays.sort(nums);

            return nSumTarget(nums, 3, 0, 0);

        }

        // 注意：调用函数前一定要 sort
        // 通用解法，n 数之和。
        private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            // 至少是 2sum
            if (n < 2 || len < n) {
                return res;
            }

            if (n == 2) {
                // 经典两数之和
                int left = start, right = len - 1;
                while (left < right) {
                    int l = nums[left], r = nums[right];
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(l, r));
                        while (left < right && nums[left] == l)
                            left++;
                        while (left < right && nums[right] == r)
                            right--;
                    } else if (sum < target) {
                        while (left < right && nums[left] == l)
                            left++;
                    } else {
                        while (left < right && nums[right] == r)
                            right--;
                    }
                }
            } else {
                // n > 2, reduce to n-1 sum
                for (int i = start; i < len; i++) {
                    List<List<Integer>> subRes = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                    for (List<Integer> list : subRes) {
                        List<Integer> subList = new ArrayList<>(list);
                        subList.add(nums[i]);
                        res.add(subList);
                    }
                    while (i < len - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }

                }
            }
            return res;

        }

    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [-1,0,1,2,-1,-4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,0,0]\n
 * // @lcpr case=end
 * 
 */
