package com.niuke.leetcode.贪心思想;

import java.util.Arrays;

/**
 * 每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于等于一个孩子的满足度，该孩子
 * 才会获得满足。求解最多可以获得满足的孩子数量。
 */
public class LC455 {
    //给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。因为最小的孩子最容易
    //得到满足，所以先满足最小的孩子。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0,result=0;
        while(i!=g.length && j!=s.length){
            if(s[j]>=g[i]){
                i++;
                j++;
                result++;                  //i与result的值相同，可直接返回i
            }else {
                j++;
            }
        }
        return result;
    }
}
