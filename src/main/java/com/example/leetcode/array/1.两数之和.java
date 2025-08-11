package com.example.leetcode.array;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t) && map.get(t) != i) {
                return new int[] { i, map.get(t) };
            }
        }
        return null;
    }

    public int[] twoSumNormal(int[] nums, int target) {
        for (int i=0; i<nums.length;i++){
            int num = target- nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(num == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}
// @lc code=end
