package com.niuke.leetcode.二分查找;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class LC69 {
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int l = 1,h = x;
        while(l <= h){
            int m = l + (h-l)/2;
            int sqrt = x/m;                     //用x/m<m而不是m*m>x防止溢出
            if(m == sqrt){
                return m;
            }else if(m > sqrt){
                h = m-1;
            }else {
                l = m+1;
            }
        }
        return h;
    }

    public int mySqrt2(int x) {          //error m*m溢出
        if(x <= 1){
            return x;
        }
        int l = 1,h = x;
        while(l <= h){
            int m = l + (h-l)/2;
            if(m*m==x){
                return m;
            }else if(m*m > x){
                h = m-1;
            }else {
                l = m+1;
            }
        }
        return h;
    }
}
