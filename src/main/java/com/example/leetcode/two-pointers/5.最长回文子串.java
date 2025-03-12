/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            String single = findPalindrome(s, i, i);
            if (single.length() >= res.length()) {
                res = single;
            }
            String doub = findPalindrome(s, i, i + 1);
            if (doub.length() >= res.length()) {
                res = doub;
            }
        }
        return res;

    }

    // 寻找最长回文串
    // left = right时，是奇数回文串
    // left+1 = right时，是偶数回文串
    public String findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 因为最后还进行了一次left--，和right++。所以需要left+1，right不需要-1.
        return s.substring(left + 1, right);
    }
}
// @lc code=end
