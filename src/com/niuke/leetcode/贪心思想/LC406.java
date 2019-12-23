package com.niuke.leetcode.贪心思想;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样
 * 高。
 * Input:[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class LC406 {
    //为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个
    //位置可能会变成第 k+1 个位置。
    //身高降序、k 值升序，然后按排好序的顺序插入队列的第 k 个位置中。
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : people){
            list.add(p[1],p);                               //List的add(int index,Object obj)方法，在第index位置插入obj
        }
        return list.toArray(new int[people.length][]);      //List的toArray(T[] a)方法，把调用的list转化为一个数组，传入数组的定义
    }
}
