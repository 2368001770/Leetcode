package com.niuke.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Main8 {
    public int JumpFloor(int n) {                                   //递归
        if(n<=2){
            return n;
        }
        return JumpFloor(n-1) + JumpFloor(n-2);
    }

    public int JumpFloor2(int n) {                                  //迭代
        if(n<=2){
            return n;
        }
        int pre1 = 1,pre2 = 2,junp = 1;
        for(int i=3;i<=n;i++){
            junp = pre1 + pre2;
            pre1 = pre2;
            pre2 = junp;
        }
        return junp;
    }
}
