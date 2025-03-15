/*
 * @lc app=leetcode.cn id=373 lang=java
 * @lcpr version=30103
 *
 * [373] 查找和最小的 K 对数字
 */
package com.example.leetcode.array;

import java.util.*;
import com.example.leetcode.base.*;

public class FindKPairsWithSmallestSums {

    // @lc code=start
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();

            // 优先队列存储 [nums1下标, nums2下标, 和]；通过合进行升序排序
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

            // 初始化：将 nums1 的每个数和 nums2[0] 组合放入队列
            // 因为两个数组都是有序的，所以这些组合一定包含最小和
            for (int i = 0; i < nums1.length; i++) {
                pq.offer(new int[] { i, 0, nums1[i] + nums2[0] });
            }
            // 获取 k 个最小对
            while (k > 0) {
                k--;
                int[] minEntity = pq.poll();
                int p1 = minEntity[0], p2 = minEntity[1];

                res.add(Arrays.asList(nums1[p1], nums2[p2]));

                // 链表中的下一个节点加入优先级队列
                if (p2 + 1 < nums2.length) {
                    pq.offer(new int[] { p1, p2 + 1, nums1[p1] + nums2[p2 + 1] });
                }
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        // put your test code here
        // [1,2,4,5,6]
        // [3,5,7,9]
        // 3
        int[] nums1 = { 1, 2, 4, 5, 6 };
        int[] nums2 = { 3, 5, 7, 9 };
        int k = 3;
        List<List<Integer>> res = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println(res);
    }
}

/*
 * // @lcpr case=start
 * // [1,7,11]\n[2,4,6]\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1,2]\n[1,2,3]\n2\n
 * // @lcpr case=end
 * 
 */
