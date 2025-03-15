/*
 * @lc app=leetcode.cn id=82 lang=java
 * @lcpr version=30103
 *
 * [82] 删除排序链表中的重复元素 II
 */

import java.util.*;
import com.example.leetcode.base.*;

public class RemoveDuplicatesFromSortedListIi {

    // @lc code=start
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 这里的重点是将重复的全部去掉，而不是保留唯一值
            // 使用链表拆分的思路
            // 运用虚拟头结点技巧，题目说了 node.val <= 100，所以用 101 作为虚拟头结点
            ListNode dummyUniq = new ListNode(101);
            ListNode dummyDup = new ListNode(101);

            ListNode uniq = dummyUniq;
            ListNode dup = dummyDup;

            ListNode p = head;
            while (p != null) {
                if ((p.next != null && p.next.val == p.val)|| p.val == dup.val) {
                    dup.next = p;
                    dup = dup.next;
                } else {
                    uniq.next = p;
                    uniq = uniq.next;
                }

                p = p.next;
            }
            uniq.next = null;
            dup.next = null;
            return dummyUniq.next;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        // put your test code here
        int[] nums = { 1, 2, 3, 3, 4, 4, 5 };
        ListNode head = ListNode.buildListNode(nums);
        ListNode res = solution.deleteDuplicates(head);
        System.out.println(res);
    }

}

/*
 * // @lcpr case=start
 * // [1,2,3,3,4,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1,1,2,3]\n
 * // @lcpr case=end
 * 
 */
