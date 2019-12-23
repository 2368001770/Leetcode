package com.niuke.leetcode.贪心思想;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。
 * 我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 */
public class LC763 {
    //遍历字符串中的每一个字符，用数组存储每个字符的最后一个位置，再次对进行遍历，更新已遍历的字符中最后一个位置，并使该位置作为结束判断条件
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexOfChar = new int[26];
        for(int i=0;i<S.length();i++){
            lastIndexOfChar[charToIndex(S.charAt(i))] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int startIndex = 0;
        while(startIndex < S.length()){
            int endIndex = startIndex;
            for(int j=startIndex;j<S.length()&&j<=endIndex;j++){
                int index = lastIndexOfChar[charToIndex(S.charAt(j))];
                if(index > endIndex){
                    endIndex = index;
                }
            }
            partitions.add(endIndex-startIndex+1);
            startIndex = endIndex + 1;
        }
        return partitions;
    }

    private int charToIndex(char c){
        return c - 'a';
    }
}
