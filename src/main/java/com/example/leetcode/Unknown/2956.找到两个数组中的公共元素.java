package com.example.leetcode.Unknown;

/*
 * @lc app=leetcode.cn id=2956 lang=java
 *
 * [2956] 找到两个数组中的公共元素
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        // return normal(nums1, nums2);
        // return map(nums1, nums2);
        return hashset(nums1,nums2);
    }

    public int[] normal(int[] nums1, int[] nums2) {
        int a1 = 0, a2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    a1++;
                    break;
                }
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] == nums2[j]) {
                    a2++;
                    break;
                }
            }
        }
        return new int[] { a1, a2 };
    }

    public int[] map(int[] nums1, int[] nums2) {
        // key: num , value: count
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i=0;i<nums2.length;i++){
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }

        int a1=0,a2=0;
        for(int num: map1.keySet()){
            if(map2.containsKey(num)){
                a1 += map1.get(num);
            }
        }
        for(int num: map2.keySet()){
            if(map1.containsKey(num)){
                a2 += map2.get(num);
            }
        }
        return new int[] { a1, a2 };
    }

    public int[] hashset(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int x : nums2) {
            set2.add(x);
        }

        int[] ans = new int[2];
        for (int x : nums1) {
            if (set2.contains(x)) {
                ans[0]++;
            }
        }
        for (int x : nums2) {
            if (set1.contains(x)) {
                ans[1]++;
            }
        }
        return ans;
    }
}
// @lc code=end
