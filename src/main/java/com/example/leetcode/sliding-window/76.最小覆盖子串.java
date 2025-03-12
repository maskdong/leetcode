/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        return growWindow(s, t);
    }

    private String growWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // 统计t中各字符需要的次数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        // valid表示 窗口中满足需要的字符个数
        int valid = 0;

        int left = 0, right = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++; // 只有当 window[c] 和 need[c] 对应的出现次数一致时，才能满足条件，valid 才能 +1
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--; // 只有当 window[d] 内的出现次数和 need[d] 相等时，才能 -1
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
// @lc code=end
