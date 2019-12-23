package com.niuke.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Main12 {
    public double Power(double base, int exponent) {        //递归，每次递归减少一半，时间复杂度O(logn)
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        boolean isNegative = false;
        if(exponent < 0){                                       //WARN 注意次方为负数的情况
            isNegative = true;
            exponent = -exponent;
        }
        double result = Power(base*base,exponent/2);
        if(exponent % 2 == 1){
            result *= base;
        }
        return isNegative?1/result:result;
    }

    public double Power2(double base, int exponent) {            //利用位运算
        int n = Math.abs(exponent);
        double result = 1;
        double pei = base;
        while(n != 0){
            if((n&1)==1){
                result *= pei;
            }
            pei *= pei;
            n>>=1;
        }
        return exponent>0?result:1/result;
    }
}
