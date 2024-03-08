/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.getMax());
                window.pop(nums[i - k + 1]);
            }
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}

class MonotonicQueue {

    // 双链表，支持头部和尾部增删元素
    // 维护其中的元素自尾部到头部单调递增
    private LinkedList<Integer> maxq = new LinkedList<>();

    public void push(int n) {
        // 将前面小于自己的元素都删除
        while (!maxq.isEmpty() && maxq.getLast() < n) {
            maxq.pollLast();
        }
        maxq.addLast(n);
    }

    public void pop(int n) {
        if (n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }

    public Integer getMax() {
        return maxq.getFirst();

    }
}
// @lc code=end
