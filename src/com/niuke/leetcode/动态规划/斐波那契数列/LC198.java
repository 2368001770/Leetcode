package com.niuke.leetcode.动态规划.斐波那契数列;

/**
 * 抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class LC198 {
    public int rob(int[] nums) {
        int pre1 = 0, pre2 = 0;
        for(int i=0; i<nums.length; i++){
            int cur = Math.max(pre2 + nums[i] , pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
