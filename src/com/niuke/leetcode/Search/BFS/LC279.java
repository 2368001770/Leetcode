package com.niuke.leetcode.Search.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, …）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class LC279 {
    public int numSquares(int n) {                          //BFS
        int result = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int curr = queue.poll();
                for(int i=1;i*i<=curr;i++){
                    if(i*i == curr){
                        return result;
                    }
                    queue.add(curr - i*i);
                }
            }
            result++;
        }
        return -1;
    }

    public int numSquares2(int n) {                         //动态规划
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = i;
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
