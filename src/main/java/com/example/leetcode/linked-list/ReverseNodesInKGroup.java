/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30104
 *
 * [25] K 个一组翻转链表
 */

import java.util.*;
import com.example.leetcode.base.*;

public class ReverseNodesInKGroup {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            // 区间 [a, b) 包含 k 个待反转元素
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转了
                if (b == null)
                    return head;
                b = b.next;
            }

            // 反转前 k 个元素
            ListNode newHead = reverseN(a, k);
            // 此时 b 指向下一组待反转的头结点
            // 递归反转后续链表并连接起来
            a.next = reverseKGroup(b, k);

            return newHead;
        }

        public ListNode reverseN(ListNode head, int n) {
            ListNode pre = null;
            ListNode cur = head;
            while (n > 0) {
                n--;
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            head.next = cur;
            return pre;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,4,5]\n3\n
 * // @lcpr case=end
 * 
 */
