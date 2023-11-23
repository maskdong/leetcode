/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int vaild = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (needMap.keySet().contains(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (needMap.get(c).equals(windowMap.get(c))) {
                    vaild++;
                }
            }

            while (right - left >= s1.length()) {
                if (vaild == needMap.keySet().size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;
                if (needMap.keySet().contains(d)) {
                    if (needMap.get(d).equals(windowMap.get(d))) {
                        vaild--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return false;
    }
}
// @lc code=end
