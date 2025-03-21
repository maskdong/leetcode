package com.example.leetcode.base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createHead(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            String arrow = cur.next != null ? "->" : "";
            System.out.print(cur.val + arrow);
        }
    }

    // 构建链表
    public static ListNode buildListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }
}
