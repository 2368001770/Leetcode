package com.niuke.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Main19 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        addNum(list,matrix,0,matrix[0].length-1,matrix.length-1);
        return list;
    }

    private static void addNum(List list,int[][] matrix,int start,int endx,int endy){       //endx,endy可以省略
        int j = start;
        while(j<=endx){
            list.add(matrix[start][j++]);
        }
        if(start<endy){
            int k = start+1;
            while(k<=endy){
                list.add(matrix[k++][endx]);
            }
        }
        if(start<endy && start<endx){
            int m = endx-1;
            while(m>=start){
                list.add(matrix[endy][m--]);
            }
        }
        if(start<endy-1 && start<endx){
            int n = endy-1;
            while(n>start){
                list.add(matrix[n--][start]);
            }
        }
        if(start+1 <=endx-1 && start+1 <=endy-1){
            addNum(list,matrix,start+1,endx-1,endy-1);
        }
    }
}
