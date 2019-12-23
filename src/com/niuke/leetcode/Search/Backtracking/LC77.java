package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(combineList, combinations, 1, k, n);
        return combinations;
    }

    private void backtracking(List<Integer> combineList, List<List<Integer>> combinations, int start, int k, final int n) {
        if(k == 0){
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for(int i=start; i<=n-k+1; i++){        //剪枝
            combineList.add(i);
            backtracking(combineList, combinations, i+1, k-1, n);
            combineList.remove(combineList.size()-1);
        }
    }
}
