package com.niuke.leetcode.二分查找;

/**
 * 在一个有重复元素的数组中查找 key 的最左位置
 */
public class Abnormal {
    public int binarySearch(int[] nums, int key) {
        int begin = 0;
        int end = nums.length-1;
        while(begin<end){
            int mindle = begin + (end-begin)/2;
            if(nums[mindle]>=key){
                end = mindle;
            }else {
                begin = mindle + 1;
            }
        }
        return begin;
    }
}
