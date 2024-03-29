package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 */
public class LC216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(k, n, 1, path, combinations);
        return combinations;
    }

    private void backtracking(int k, int n, int start, List<Integer> tempCombination, List<List<Integer>> combinations) {
        if(k == 0 && n == 0){
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        if(k == 0 || n <= 0){
            return;
        }
        for(int i=start; i<=9; i++){
            tempCombination.add(i);
            backtracking(k-1, n-i, i+1, tempCombination, combinations);
            tempCombination.remove(tempCombination.size()-1);
        }
    }
}
