package com.niuke.leetcode.贪心思想;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 */
public class LC121 {
    //只需要记录当前的最小元素值，若比最小值大，则把当前值与最小值的差与最大利润值判断，大于最大利润则更新最大利润值
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int minPrice = prices[0];
        //int maxProfit = prices[0];
        int maxProfit = 0;             //注意不能为prices[0],如：[7,1,5,3,6,4]，应该输出5而不是7，第一个元素不应该作为最大利润
        for(int i=0; i<prices.length; i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }else {
                maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
}
