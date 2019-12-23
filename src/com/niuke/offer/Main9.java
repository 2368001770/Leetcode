package com.niuke.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Main9 {
    public int JumpFloorII(int target) {
        if(target <= 2){
            return target;
        }
        int[] jump = new int[target];
        jump[0] = 1;
        jump[1] = 2;
        for(int i=2;i<target;i++){
            for(int j=0;j<i;j++){
                jump[i] += jump[j];
            }
            jump[i]++;                                  //WARN 从第0阶台阶直接调到targe,故加1
        }
        return jump[target-1];
    }

    public int JumpFloorII2(int target) {               //等比数列
        if(target <= 2){
            return target;
        }
        int result = 2;
        for(int i=3;i<=target;i++){
            result *= 2;
        }
        return result;
    }

    public int JumpFloorII3(int target) {
        return (int) Math.pow(2,target-1);
    }
}
