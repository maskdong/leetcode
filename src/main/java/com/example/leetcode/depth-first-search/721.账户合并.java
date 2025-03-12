/*
 * @lc app=leetcode.cn id=721 lang=java
 *
 * [721] 账户合并
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 使用并查集，找图空间中相同的邮箱关联起来的集合
        HashMap<String, Integer> emailToIndex = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();

        int emailsCount = 0;
        // 构建map
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    // 新的email
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        // 构建并查集
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }


        HashMap<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;


    }
}

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        // 初始化时，每个节点的父节点就是自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2){
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

}
// @lc code=end
