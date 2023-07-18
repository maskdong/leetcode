/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null)
            return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null)
                return head;
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    // 迭代反转链表
    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    public ListNode reverse(ListNode head, ListNode end) {
        ListNode pre, cur, next;
        pre = null;
        cur = next = head;

        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur; 
            cur = next;
        }
        return pre;
    }
}
// @lc code=end
