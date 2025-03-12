package com.example.leetcode.linkedlist;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

import com.example.leetcode.base.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    /*
     * pA走过的路径为A链+B链
     * 
     * pB走过的路径为B链+A链
     * 
     * pA和pB走过的长度都相同，都是A链和B链的长度之和，相当于将两条链从尾端对齐，如果相交，则会提前在相交点相遇，如果没有相交点，则会在最后相遇。
     * 
     * pA:1->2->3->4->5->6->null->9->5->6->null
     * pB:9->5->6->null->1->2->3->4->5->6->null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;

    }

    // Time Limit Exceeded
    public ListNode planA(ListNode headA, ListNode headB) {
        Set<ListNode> aLinkSet = new HashSet<>();
        while (headA != null) {
            aLinkSet.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (aLinkSet.contains(headB)) {
                return headB;
            }
        }
        return null;
    }
}
// @lc code=end
