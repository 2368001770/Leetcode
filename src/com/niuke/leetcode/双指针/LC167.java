package com.niuke.leetcode.双指针;

/**
 * 在有序数组中找出两个数，使它们的和为 target。
 */
public class LC167 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        while(start < end){
            int currSum = numbers[start] + numbers[end];
            if(currSum == target){
                return new int[]{start+1,end+1};
            }else if(currSum < target){
                start++;
            }else {
                end--;
            }
        }
        return null;
    }
}
