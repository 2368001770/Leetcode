package com.niuke.leetcode.二分查找;

/**
 * 正常二分查找
 */
public class Normal {
    public int binarySearch(int[] nums, int key) {
        int begin = 0;
        int end = nums.length-1;
        while(begin<=end){
            int mindle = (begin+end)/2;             //int mindle = begin + (end-begin)/2 可防止（begin+end）过大越界
            if(nums[mindle]==key){
                return mindle;
            }else if(nums[mindle]>key){
                end = mindle-1;
            }else {
                begin = mindle + 1;
            }
        }
        return -1;
    }
}
