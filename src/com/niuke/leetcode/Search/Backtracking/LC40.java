package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(new ArrayList<>(), combinations, new boolean[candidates.length], 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations, boolean[] hasVisited, int start, int target, final int[] candidates) {
        if(target == 0){
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for(int i=start; i<candidates.length; i++){
            if (i!=0 && candidates[i]==candidates[i-1] && !hasVisited[i-1]){
                continue;
            }
            if(candidates[i] <= target){
                tempCombination.add(candidates[i]);
                hasVisited[i] = true;
                backtracking(tempCombination, combinations, hasVisited, i+1, target-candidates[i], candidates);
                tempCombination.remove(tempCombination.size()-1);
                hasVisited[i] = false;
            }
        }
    }
}
