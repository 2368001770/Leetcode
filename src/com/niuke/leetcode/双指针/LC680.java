package com.niuke.leetcode.双指针;

/**
 * 可以删除一个字符，判断是否能构成回文字符串。
 */
public class LC680 {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                return isPalindrome(s,start+1,end) || isPalindrome(s,start,end-1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s,int start,int end){      //判断字符串s在start到end下标范围内是否回文
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
