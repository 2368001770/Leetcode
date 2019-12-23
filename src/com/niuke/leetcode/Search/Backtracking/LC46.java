package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList, permutes, hasVisited, nums);
        return permutes;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
        if(permuteList.size() == nums.length){
            permutes.add(new ArrayList<>(permuteList));          //需要重新构造一个List，否则list集合中每个元素都会指向这个permuteList的地址空间，最后都为null
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            backtracking(permuteList, permutes, visited , nums);
            visited[i] = false;
            permuteList.remove(permuteList.size() - 1);
        }
    }
}
