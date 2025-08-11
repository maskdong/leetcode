/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30202
 *
 * [49] 字母异位词分组
 */

import java.util.*;
import com.example.leetcode.base.*;

public class GroupAnagrams {

    // @lc code=start
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 编码到分组的映射
            Map<String,List<String>> codeToStrsMap = new HashMap<>();

            for(String str : strs){
                String code = encode(str);
                // 如果是新的 code，则先创建一个 list
                codeToStrsMap.putIfAbsent(code, new ArrayList<>());
                codeToStrsMap.get(code).add(str);
            }

            List<List<String>> result = new ArrayList<>();
            for(List<String> value : codeToStrsMap.values()){
                result.add(value);
            }

            return result;
        }

        private String encode(String str) {
            char[] code = new char[26];
            for (char c : str.toCharArray()) {
                int index = c-'a';
                code[index]++;
            }
            return new String(code);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // ["eat", "tea", "tan", "ate", "nat", "bat"]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [""]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["a"]\n
 * // @lcpr case=end
 * 
 */
