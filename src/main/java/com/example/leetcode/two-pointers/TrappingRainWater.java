/*
 * @lc app=leetcode.cn id=42 lang=java
 * @lcpr version=30202
 *
 * [42] 接雨水
 */

import java.util.*;
import com.example.leetcode.base.*;

public class TrappingRainWater {

    // @lc code=start
    class Solution {

        public int trapTowPoint(int[] height) {
            // 双指针
            if (height.length == 0) {
                return 0;
            }

            int res = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;

            while (left < right) {
                if (height[left] < height[right]) {
                    // 移动左边
                    if (height[left] > leftMax) {
                        // 该列，无法存水，左边有低的（右边有什么都无关）
                        leftMax = height[left];
                    } else {
                        // 该列可以存水，存水多少取决于短边，因为上面的判断所以左边短边
                        res += leftMax - height[left];
                    }
                    left++;

                } else {
                    if (height[right] >= rightMax)
                        rightMax = height[right];
                    else
                        res += rightMax - height[right];
                    right--;
                }
            }

            return res;
        }

        public int trap(int[] height) {
            // 预计算
            if (height.length == 0) {
                return 0;
            }

            int res = 0;
            int len = height.length;
            // 预计算，leftmax 含义是 i 值左边包括 i 的最大值。
            int[] leftMax = new int[len];
            int[] rightMax = new int[len];

            leftMax[0] = height[0];
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            rightMax[len - 1] = height[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            // waterLevel = min(leftMax[i], rightMax[i])
            // water[i] = max(waterLevel - height[i], 0)
            for (int i = 0; i < len; i++) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [0,1,0,2,1,0,1,3,2,1,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [4,2,0,3,2,5]\n
 * // @lcpr case=end
 * 
 */
