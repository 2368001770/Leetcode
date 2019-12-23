package com.niuke.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Main11 {
    public static int NumberOf1(int n){            //Integer的bitCount方法可获得二进制中1的个数
        return Integer.bitCount(n);
    }

    public static int NumberOf12(int n){           //Integer的toBinaryString可获得二进制字符串
        String string = Integer.toBinaryString(n);
        int count = 0;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }

    public static int NumberOf13(int n){            //n & (n-1)可消除二进制中最右边的1
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
