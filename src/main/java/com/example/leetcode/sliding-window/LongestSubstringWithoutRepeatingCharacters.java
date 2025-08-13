/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30202
 *
 * [3] 无重复字符的最长子串
 */

import java.util.*;
import com.example.leetcode.base.*;

public class LongestSubstringWithoutRepeatingCharacters {

    // @lc code=start
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int left = 0, right = 0;
            Set<Character> set = new HashSet<>();
            int maxLen = 0;

            while (right < s.length()) {
                char rc = s.charAt(right);
                while (set.contains(rc)) {
                    char lc = s.charAt(left);
                    set.remove(lc);
                    left++;
                }
                set.add(rc);
                maxLen = Math.max(maxLen, set.size());
                right++;
            }
            return maxLen;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // "abcabcbb"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "bbbbb"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "pwwkew"\n
 * // @lcpr case=end
 * 
 */
