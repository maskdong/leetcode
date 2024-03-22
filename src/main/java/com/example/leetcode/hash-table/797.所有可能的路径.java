/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start


import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0, new LinkedList<>());
        return res;
    }

    /* 图的遍历框架 */
    void traverse(int[][] graph, int s, LinkedList<Integer> path) {

        // 添加节点 s 到路径
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            // 可以在这直接 return，但要 removeLast 正确维护 path
            // path.removeLast();
            // return;
            // 不 return 也可以，因为图中不包含环，不会出现无限递归
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        
        // 从路径移出节点 s
        path.removeLast();
    }
}
// @lc code=end
