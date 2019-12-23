package com.niuke.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有赞编程题
 * 求0~n范围内的数字中那个没有出现
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
        System.out.println(lack(list));
    }
    private static Integer lack(List<Integer> source){
        int[] ints = new int[source.size()+1];
        for(int i=0;i<source.size();i++){
            ints[source.get(i)] = 1;
        }
        for(int j=0;j<ints.length;j++){
            if(ints[j]==0){
                return j;
            }
        }
        return null;
    }
}
