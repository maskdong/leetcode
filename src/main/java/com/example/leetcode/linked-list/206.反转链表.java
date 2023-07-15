/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // 1. base case 当为空或者一个节点时，返回本身即可
        if (head == null || head.next == null) {
            return head;
        }

        // 2. 调用递归函数，返回 head.next 到末尾的反转链表。返回的节点为反转后的头结点（即最后一个点）
        ListNode lest = reverseList(head.next);

        // 3. 将反转后的链表末端指向 head 节点，并将 head 末尾置空。
        head.next.next = head;
        head.next = null;
        return lest;
    }
}
// @lc code=end
