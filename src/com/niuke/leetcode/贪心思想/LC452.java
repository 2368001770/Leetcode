package com.niuke.leetcode.贪心思想;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都会刺破。求解最小的
 * 投飞镖次数使所有气球都被刺破。
 */
public class LC452 {
    //先按每组元素的结束值进行排序，记录当前次飞镖的end值，与下个元素的start值做比较，大于end值可在当前次的飞镖打中
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int cnt = 1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=end){
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
