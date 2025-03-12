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
        for (String dead : deadends) {
            deads.add(dead);
        }
        // 初始化
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();
                if (deads.contains(curStr)) {
                    continue;
                }
                if (curStr.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(curStr, j);
                    if (!visited.contains(plusOne)) {
                        // 新的组合
                        visited.add(plusOne);
                        queue.offer(plusOne);
                    }

                    String minusOne = minusOne(curStr, j);
                    if (!visited.contains(minusOne)) {
                        visited.add(minusOne);
                        queue.offer(minusOne);
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
