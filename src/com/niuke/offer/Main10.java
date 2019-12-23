package com.niuke.offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Main10 {
    public int RectCover(int n) {               //递归
        if(n <= 2){
            return n;
        }
        return RectCover(n-1) + RectCover(n-2);
    }

    public int RectCover2(int n) {          //迭代
        if(n <= 2){
            return n;
        }
        int pre1 = 1,pre2 = 2,result = 2;
        for(int i=2;i<n;i++){
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
}
