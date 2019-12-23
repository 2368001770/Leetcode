package com.niuke.offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 */
public class Main7 {
    public int Fibonacci(int n) {               //数组储存
        if(n < 2){
            return n;
        }
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public int Fibonacci2(int n) {                              //迭代
        if(n<2){
            return n;
        }
        int i=0,j=1;
        while(--n>0){
            int temp = i+j;
            i = j;
            j = temp;
        }
        return j;
    }

    public int Fibonacci3(int n) {                              //最大值39，可用数组把所有的结果存储起来，以后取时时间复杂度O(1)
        int[] fib = new int[40];
        fib[1] = 1;
        for(int i=2;i<=39;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}
