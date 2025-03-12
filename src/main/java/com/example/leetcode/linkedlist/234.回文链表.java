package com.example.leetcode.linkedlist;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到后半段并反转
        ListNode midNode = findMidNode(head);
        ListNode reverseNode = reverseList(midNode.next);

        // 判断是否回文
        ListNode list1 = head;
        ListNode list2 = reverseNode;
        boolean equal = true;
        while (equal && list2 != null) {
            if (list1.val != list2.val) {
                equal = false;
                break;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        midNode.next = reverseList(reverseNode);
        return equal;
    }

    /*
     * 迭代反转链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 快慢指针找中间节点
    // 偶数时，mid 为前半段最后节点
    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
// @lc code=end
