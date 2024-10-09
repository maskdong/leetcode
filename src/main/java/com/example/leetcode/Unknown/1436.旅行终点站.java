/*
 * @lc app=leetcode.cn id=1436 lang=java
 *
 * [1436] 旅行终点站
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }

        for (String value: map.values()) {
            if (!map.containsKey(value)) {
                return value;
            }
        }
        return null;
    }
}
// @lc code=end
