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
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 初始化needMap
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            // c 是将移入窗口的字符
            char c = s2.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                // d 是将移出窗口的字符
                char d = s2.charAt(left);
                // 左移窗口
                left++;

                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }
}
// @lc code=end
