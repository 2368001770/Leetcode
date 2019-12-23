package com.niuke.leetcode.二分查找;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums,target);
        int right = binarySearch(nums,target+1) - 1;
        if(left == nums.length || nums[left] != target){
            return new int[]{-1,-1};
        }else {
            return new int[]{left,right};
        }
    }
    private int binarySearch(int[] nums,int target){
        int l = 0,h = nums.length;      //注意h的初始值，如果为nums.length-1,{[3],4}预期返回1而实际返回0
        while(l<h){
            int m = l + (h-l)/2;
            if(nums[m]>=target){        //2,4,5找3，h不能赋值为m-1
                h = m;
            }else {
                l = m + 1;
            }
        }
        return l;
    }
}
