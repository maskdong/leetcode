/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.HashMap;

import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // key是字符，value是字符对应的个数
        Map<Character, Integer> windowMap = new HashMap<>();

        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 更新窗口内数据
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // 判断是否要缩小左侧窗口
            while (windowMap.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 更新窗口内数据
                windowMap.put(d, windowMap.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
// @lc code=end
