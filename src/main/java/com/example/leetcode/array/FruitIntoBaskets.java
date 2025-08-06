package com.example.leetcode.array;

/*
 * @lc app=leetcode.cn id=904 lang=java
 * @lcpr version=30201
 *
 * [904] 水果成篮
 */

import java.util.*;


public class FruitIntoBaskets {

    // @lc code=start
    class Solution {
        public int totalFruit(int[] fruits) {

            int maxCount = 0;
            int curCount = 0;
            int slow = 0, fast = 0;
            HashMap<Integer, Integer> fMap = new HashMap<>();

            for (; fast < fruits.length; fast++) {
                int fruit = fruits[fast];

                // Add fruit to the basket
                fMap.put(fruit, fMap.getOrDefault(fruit, 0) + 1);
                curCount++;

                // If we have more than 2 types, move slow pointer
                while (fMap.size() > 2) {
                    int slowFruit = fruits[slow];
                    fMap.put(slowFruit, fMap.get(slowFruit) - 1);
                    if (fMap.get(slowFruit) == 0) {
                        fMap.remove(slowFruit);
                    }

                    curCount--;
                    slow++;
                }

                // Update maxCount
                maxCount = Math.max(maxCount, curCount);
            }

            return maxCount;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
        // put your test code here
        int[] fruits = { 0, 1, 2, 2 };
        int totalFruit = solution.totalFruit(fruits);
        System.out.println(totalFruit);
    }
}

/*
 * // @lcpr case=start
 * // [1,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,2,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,2,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,3,3,1,2,1,1,2,3,3,4]\n
 * // @lcpr case=end
 * 
 */
