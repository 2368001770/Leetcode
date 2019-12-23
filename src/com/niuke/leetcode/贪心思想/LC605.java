package com.niuke.leetcode.贪心思想;

/**
 * 花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 */
public class LC605 {
    //若当前位置为0，并且前一个和后一个位置都为0，则当前位置可以种植一朵花，并把当前位置的值改为1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        int len = flowerbed.length;
        for(int i=0;i<len&&cnt<n;i++){
            if(flowerbed[i]==1){
                continue;
            }
            int pre = i==0?0:flowerbed[i-1];
            int next = i==len-1?0:flowerbed[i+1];
            if(pre==0 && next==0){
                flowerbed[i] = 1;
                cnt++;
            }
        }
        return cnt>=n;
    }
}
