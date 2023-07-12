/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start

import com.example.leetcode.base.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
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
     * 根据：
     *      f=2s （快指针每次2步，路程刚好2倍）
     *      f = s + nb (相遇时，刚好多走了n圈）
     * 推出：s = nb
     * 
     * 从head结点走到入环点需要走 ： a + nb， 而slow已经走了nb，那么slow再走a步就是入环点了。
     * 如何知道slow刚好走了a步？ 从head开始，和slow指针一起走，相遇时刚好就是a步
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        Boolean isCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        // 无环状态
        if (!isCycle) {
            return null;
        }

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end
