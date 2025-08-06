/*
 * @lc app=leetcode.cn id=92 lang=java
 * @lcpr version=30103
 *
 * [92] 反转链表 II
 */

import java.util.*;
import com.example.leetcode.base.*;

public class ReverseLinkedListIi {

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
        public ListNode reverseBetween(ListNode head, int left, int right) {

            // 创建哑节点处理头节点被反转的情况
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;

            // 定位到反转区间的前一个节点
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            ListNode curr = pre.next;
            // 逐步反转区间内的节点
            for (int i = 0; i < right - left; i++) {
                ListNode nextNode = curr.next; // 1. 保存下一个节点
                curr.next = nextNode.next; // 2. 断开当前节点与nextNode的连接
                nextNode.next = pre.next; // 3. 将nextNode连接到pre的下一个节点
                pre.next = nextNode; // 4. 更新pre的next指针
            }

            return dummy.next;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [1,2,3,4,5]\n2\n4\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [5]\n1\n1\n
 * // @lcpr case=end
 * 
 */
