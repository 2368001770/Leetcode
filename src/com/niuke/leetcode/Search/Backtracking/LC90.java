package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] hasVisited = new boolean[nums.length];
        for(int size=0; size<=nums.length; size++){
            backtracking(0, tempSubset, subsets, hasVisited, size, nums);
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets, boolean[] hasVisited, final int size, final int[] nums) {
        if(tempSubset.size() == size){
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(i!=0 && nums[i]==nums[i-1] && !hasVisited[i-1]){
                continue;
            }
            tempSubset.add(nums[i]);
            hasVisited[i] = true;
            backtracking(i+1, tempSubset, subsets, hasVisited, size, nums);
            tempSubset.remove(tempSubset.size()-1);
            hasVisited[i] = false;
        }
    }
}
