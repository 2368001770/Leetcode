package com.niuke.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Main47 {
    public int Sum_Solution(int n) {                //与短路特性可用于判断，递归进行加法运算
        int sum = 0;
        boolean bool = n>0 && (sum=n+Sum_Solution(n-1))>0;
        return sum;
    }
}
