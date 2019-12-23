package com.niuke.leetcode.双指针;

/**
 * 判断一个数是否为两个数的平方和。
 */
public class LC633 {
    public boolean judgeSquareSum(int c) {
        int start = 0;                          //start从0开始
        int end = (int) Math.sqrt(c);
        while(start <= end){                    //start可以和end相等（1*1+1*1=2）
            int currSum = start*start + end*end;
            if(currSum == c){
                return true;
            }else if(currSum < c){
                start++;
            }else{
                end--;
            }
        }
        return false;
    }
}
