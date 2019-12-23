package com.niuke.offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Main48 {
    public int Add(int num1,int num2) {    //用异或运算求和，与运算再向左移一位求进位，两者在做异或求和，直到进位为0
        while(num2 != 0){
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
