package com.niuke.leetcode.二分查找;

/**
 * 给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果
 * 找不到就返回第 1 个字符。
 *
 * Input:letters = ["c", "f", "j"]  target = "d"
 * Output: "f"
 *
 * Input:letters = ["c", "f", "j"]  target = "k"
 * Output: "c"
 */
public class LC744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0,h = n-1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(letters[m]<=target){
                l = m + 1;
            }else {
                h = m - 1;
            }
        }
        return l<n ? letters[l] : letters[0];
    }
}
