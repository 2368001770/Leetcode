package com.niuke.offer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Main51 {
    public int[] multiply(int[] A) {                    //想象成一个矩阵，左上角右下角分割线分开，第一次遍历左边，第二次遍历右边
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i=1;i<B.length;i++){
            B[i] = B[i-1]*A[i-1];
        }
        int temp = A[A.length-1];
        for(int j=B.length-2;j>=0;j--){
            B[j] = B[j]*temp;
            temp = temp*A[j];
        }
        return B;
    }
}
