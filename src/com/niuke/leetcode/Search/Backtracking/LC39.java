package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 */
public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<Integer>(), combinations, 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations, int start, int target, final int[] candidates) {
        if(target == 0){
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        for(int i=start; i<candidates.length; i++){
            if(candidates[i] <= target){
                tempCombination.add(candidates[i]);
                backtracking(tempCombination, combinations, i, target-candidates[i], candidates);
                tempCombination.remove(tempCombination.size()-1);
            }
        }
    }
}
