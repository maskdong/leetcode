/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start

import java.util.PriorityQueue;

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

    // 使用优先级队列 即二叉堆将 lists 先进行排序。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // 优先级队列，最小堆
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                pQueue.add(head);
            }
        }

        while (!pQueue.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pQueue.poll();
            temp.next = node;
            temp = temp.next;
            // 将未使用的 node 重新 add 到pQueue。
            if (node.next != null) {
                pQueue.add(node.next);
            }

        }
        return dummy.next;

    }

}
// @lc code=end
