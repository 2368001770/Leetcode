package com.niuke.leetcode.Search.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class LC131 {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        doPartition(s, partitions, tempPartition);
        return partitions;
    }

    private void doPartition(String s, List<List<String>> partitions, List<String> tempPartition) {
        if(s.length() == 0){
            partitions.add(new ArrayList<>(tempPartition));
            return;
        }
        for(int i=0; i<s.length(); i++){
            if(isPalindrome(s, 0, i)){
                tempPartition.add(s.substring(0,i+1));
                doPartition(s.substring(i+1),partitions,tempPartition);
                tempPartition.remove(tempPartition.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end){
            if(s.charAt(begin++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
