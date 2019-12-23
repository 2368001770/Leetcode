package com.niuke.leetcode.贪心思想;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class LC53 {
    //只需要把记录以当前元素结束的数组的最大值和总体的最大值
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int preSum = nums[0];
        int maxSum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(preSum > 0){
                preSum = preSum + nums[i];
            }else {
                preSum = nums[i];
            }
            maxSum = Math.max(preSum,maxSum);
        }
        return maxSum;
    }
}
