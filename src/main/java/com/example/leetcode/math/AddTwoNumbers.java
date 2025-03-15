/*
 * @lc app=leetcode.cn id=2 lang=java
 * @lcpr version=30103
 *
 * [2] 两数相加
 */

import java.util.*;
import com.example.leetcode.base.*;

public class AddTwoNumbers {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            ListNode p1 = l1;
            ListNode p2 = l2;
            // 记录进位
            int up = 0;
            while (p1 != null || p2 != null) {
                int res = up;
                if (p1 != null) {
                    res += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    res += p2.val;
                    p2 = p2.next;
                }
                up = res / 10;
                p.next = new ListNode(res % 10);
                p = p.next;
            }
            if (up == 1) {
                p.next = new ListNode(up);
            }
            return dummy.next;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [2,4,3]\n[5,6,4]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n[0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [9,9,9,9,9,9,9]\n[9,9,9,9]\n
 * // @lcpr case=end
 * 
 */
