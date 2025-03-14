/*
 * @lc app=leetcode.cn id=86 lang=java
 * @lcpr version=30103
 *
 * [86] 分隔链表
 */


import java.util.*;
import com.example.leetcode.base.*;

public class PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(-1);
            ListNode cur1 = dummy1;
            ListNode dummy2 = new ListNode(-1);
            ListNode cur2 = dummy2;
            while (head != null) {
                if (head.val < x) {
                    cur1.next = head;
                    cur1 = cur1.next;
                } else {
                    cur2.next = head;
                    cur2 = cur2.next;
                }
                head = head.next;
            }
            cur1.next = dummy2.next;
            // 将 cur2 置空，防止循环; 
            // 因为cur2 结尾不一定是 head 链的最后一个节点，可能后面还有比 x 小的节点，这样会有循环。
            cur2.next = null;
            return dummy1.next;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        // put your test code here
        
    }
}



/*
// @lcpr case=start
// [1,4,3,2,5,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [2,1]\n2\n
// @lcpr case=end

 */

