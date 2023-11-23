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
        Map<Character, Integer> windowMap = new HashMap<>();

        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            while (windowMap.get(c) > 1) {
                Character d = s.charAt(left);
                left++;
                windowMap.put(d, windowMap.get(d) - 1);
            }

            res = Math.max(res, right - left);
        }
        return res;
    }
}
// @lc code=end
