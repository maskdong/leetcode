package com.example.leetcode.array;

/*
 * @lc app=leetcode.cn id=378 lang=java
 * @lcpr version=30103
 *
 * [378] 有序矩阵中第 K 小的元素
 */

import java.util.*;


public class KthSmallestElementInASortedMatrix {

    // @lc code=start
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            // 优先队列存每行中最小的值
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                return a[0] - b[0];
            });
            // 初始化优先队列
            for (int i = 0; i < matrix.length; i++) {
                pq.add(matrix[i]);
            }
            int res = -1;
            while (!pq.isEmpty() && k > 0) {
                int[] poll = pq.poll();
                res = poll[0];
                k--;

                // 删除数组第一个值
                if (poll.length > 1) {
                    pq.add(Arrays.copyOfRange(poll, 1, poll.length));
                }
                
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [[1,5,9],[10,11,13],[12,13,15]]\n8\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[-5]]\n1\n
 * // @lcpr case=end
 * 
 */
