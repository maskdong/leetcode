/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            // 开始每层遍历
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                // 结束条件
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String plusStr = plusOne(cur, j);
                    if (!visited.contains(plusStr)) {
                        q.offer(plusStr);
                        visited.add(plusStr);
                    }
                    String minusString = minusOne(cur, j);
                    if (!visited.contains(minusString)) {
                        q.offer(minusString);
                        visited.add(minusString);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] -= 1;
        }
        return new String(ch);
    }
}
// @lc code=end
