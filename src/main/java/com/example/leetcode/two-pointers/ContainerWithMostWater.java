/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30202
 *
 * [11] 盛最多水的容器
 */

import java.util.*;
import com.example.leetcode.base.*;

public class ContainerWithMostWater {

    // @lc code=start
    class Solution {
        public int maxArea(int[] height) {
            // 双指针方式
            int left = 0, right = height.length - 1;
            int maxArea = 0;

            while (left < right) {
                int area = (right - left) * Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, area);

                // 缩小边界，移动较低的一边，这样才可能有更大的值出现（因为较短的边仍然限制了高度）
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }

        public int normal(int[] height) {
            // 暴力解法，会超时
            int maxArea = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
                }
            }
            return maxArea;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [1,8,6,2,5,4,8,3,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1]\n
 * // @lcpr case=end
 * 
 */
