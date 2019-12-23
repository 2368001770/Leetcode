package com.niuke.offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Main42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0,end = array.length - 1;
        while(start < end){
            int startNum = array[start];
            int endNum = array[end];
            if(startNum+endNum == sum){
                list.add(startNum);
                list.add(endNum);
                return list;
            }else if(startNum+endNum > sum){
                end--;
            }else {
                start++;
            }
        }
        return list;
    }
}
