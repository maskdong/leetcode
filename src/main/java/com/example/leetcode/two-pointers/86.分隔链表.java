/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start

import com.example.leetcode.base.ListNode;

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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode t1 = dummy1;
        ListNode t2 = dummy2;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                t1.next = temp;
                t1 = t1.next;
            } else {
                t2.next = temp;
                t2 = t2.next;
            }
            // 需要断开原有的节点链接
            ListNode tempNext = temp.next;
            temp.next = null;
            temp = tempNext;

        }
        t1.next = dummy2.next;
        return dummy1.next;
    }
}
// @lc code=end
