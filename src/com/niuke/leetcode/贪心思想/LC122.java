package com.niuke.leetcode.贪心思想;

/**
 * 一次股票交易包含买入和卖出，多个交易之间不能交叉进行。
 */
public class LC122 {
    //当当前元素大于上一个元素，即算一次交易
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                profit += (prices[i]-prices[i-1]);
            }
        }
        return profit;
    }
}
