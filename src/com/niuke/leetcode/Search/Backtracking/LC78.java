package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        for(int i=0; i<=nums.length; i++){
            backtracking(0, tempSubset, subsets, i, nums);
        }
        return subsets;
    }

    private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets, final int size, final int[] nums) {
        if(tempSubset.size() == size){
            subsets.add(new ArrayList<>(tempSubset));
            return;
        }
        for(int i=start; i<nums.length; i++){
            tempSubset.add(nums[i]);
            backtracking(i+1, tempSubset, subsets, size, nums);
            tempSubset.remove(tempSubset.size()-1);
        }
    }
}
