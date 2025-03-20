/*
 * @lc app=leetcode.cn id=206 lang=java
 * @lcpr version=30103
 *
 * [206] 反转链表
 */

import java.util.*;
import com.example.leetcode.base.*;

public class ReverseLinkedList {

    // @lc code=start
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
           // 递归反转
           if (head == null || head.next==null){
            return head;
           }
           ListNode last = reverseList(head.next);
           head.next.next = head;
           head.next = null;
           return last;
        }

        // 这是原地反转的一种方法。
        public ListNode reverseList1(ListNode head) {
            ListNode pre = null;
            while (head!=null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

