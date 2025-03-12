/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 记录后驱节点
    ListNode reversedNext = null;

    /*
     * 反转前 n个节点
     */
    public ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            reversedNext = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = reversedNext;

        return last;
    }
}
// @lc code=end
