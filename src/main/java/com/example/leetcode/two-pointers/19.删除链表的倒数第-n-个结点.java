/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 找到倒数第 n+1个节点.
        // 重点：传递 dummy，防止[1],1的空指针情况
        ListNode node = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        node.next = node.next.next;

        return dummy.next;
    }

    private ListNode findFromEnd(ListNode node, int n) {
        ListNode slow = node;
        ListNode fast = node;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end
