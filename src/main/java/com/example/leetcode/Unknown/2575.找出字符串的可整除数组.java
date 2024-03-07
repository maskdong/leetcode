/*
 * @lc app=leetcode.cn id=2575 lang=java
 *
 * [2575] 找出字符串的可整除数组
 */

// @lc code=start
class Solution {
    // 
    public int[] divisibilityArray(String word, int m) {
        char[] s = word.toCharArray();
        int[] ans = new int[s.length];
        long x = 0;
        for (int i = 0; i < s.length; i++) {
            x = (x * 10 + (s[i] - '0')) % m;
            if (x == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    public int[] error(String word, int m) {
        // 不能使用long计算，在10次方的时候会溢出，要使用模运算
        int size = word.length();
        int[] res = new int[size];
        long cur = 0;

        for (int i = 0; i < size; i++) {
            long num = Long.parseLong(word.substring(0,i+1));
            cur = num;
            System.out.println(String.format("i:%s,num:%s", i, num));
            if (num % m == 0) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
// @lc code=end
