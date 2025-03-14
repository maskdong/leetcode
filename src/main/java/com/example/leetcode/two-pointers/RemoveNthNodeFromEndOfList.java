/*
 * @lc app=leetcode.cn id=19 lang=java
 * @lcpr version=30103
 *
 * [19] 删除链表的倒数第 N 个结点
 */

import java.util.*;
import com.example.leetcode.base.*;

public class RemoveNthNodeFromEndOfList {

    // @lc code=start
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
            ListNode fast = dummy;
            ListNode slow = dummy;
            for (int i = 0; i < n ; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;

            }
            slow.next = slow.next.next;
            return  dummy.next;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n1\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n1\n
 * // @lcpr case=end
 * 
 */
