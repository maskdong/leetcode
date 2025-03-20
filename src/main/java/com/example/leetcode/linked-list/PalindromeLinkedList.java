/*
 * @lc app=leetcode.cn id=234 lang=java
 * @lcpr version=30103
 *
 * [234] 回文链表
 */

import java.util.*;


import com.example.leetcode.base.*;

public class PalindromeLinkedList {

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
        public boolean isPalindrome(ListNode head) {
            Stack<Integer> stk = new Stack<>();
            ListNode slow = head;
            ListNode fast = head;
            
            // 将左半部分节点入栈
            while (fast != null && fast.next != null) {
                stk.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }
            
            // 如果是奇数长度，跳过中间节点
            if (fast != null) {
                slow = slow.next;
            }
            
            // 比较右半部分
            while (slow != null) {
                if (stk.isEmpty() || slow.val != stk.pop()) {
                    return false;
                }
                slow = slow.next;
            }
            
            return stk.isEmpty();
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [1,2,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n
 * // @lcpr case=end
 * 
 */
