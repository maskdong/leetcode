/*
 * @lc app=leetcode.cn id=438 lang=java
 * @lcpr version=30202
 *
 * [438] 找到字符串中所有字母异位词
 */

import java.util.*;
import com.example.leetcode.base.*;

public class FindAllAnagramsInAString {

    // @lc code=start
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            Map<Character, Integer> targetMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();

            for (char c : p.toCharArray()) {
                targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            }

            List<Integer> res = new ArrayList<>();
            int left = 0, right = 0;
            int valid = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (targetMap.containsKey(c)) {
                    windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                    if (windowMap.get(c).equals(targetMap.get(c))) {
                        valid++;
                    }
                }

                // 判断左边界
                while (right - left >= p.length()) {
                    if (valid == targetMap.size()) {
                        res.add(left);
                    }
                    char d = s.charAt(left);
                    left++;

                    if (targetMap.containsKey(d)) {
                        if (windowMap.get(d).equals(targetMap.get(d))) {
                            valid--;
                        }
                        windowMap.put(d, windowMap.get(d) - 1);
                    }

                }
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // "cbaebabacd"\n"abc"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "abab"\n"ab"\n
 * // @lcpr case=end
 * 
 */
