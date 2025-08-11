/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30202
 *
 * [128] 最长连续序列
 */

import java.util.*;
import com.example.leetcode.base.*;

public class LongestConsecutiveSequence {

    // @lc code=start
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int maxCount = 0;

            // 注意!遍历的不是 nums 而是 set
            for (int num : set) {
                if (set.contains(num - 1)) {
                    // 1. 寻找这个数字是不是开头，当有 -1 存在，不是开头。
                    continue;
                }

                // 2. 如果是开头，判断能持续多长
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curLen++;
                    curNum++;
                }
                maxCount = Math.max(maxCount, curLen);
            }
            return maxCount;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [100,4,200,1,3,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,3,7,2,5,8,4,6,0,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,0,1,2]\n
 * // @lcpr case=end
 * 
 */
