package com.niuke.leetcode.双指针;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 翻转单词中的元音字母
 * Given s = "leetcode", return "leotcede".
 */
public class LC345 {

    //用HashSet来存储元音字母，构造方法中可以传入一个集合
    private static final HashSet<Character> charSet = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] result = new char[s.length()];
        while(start <= end){
            if(charSet.contains(s.charAt(start))&&charSet.contains(s.charAt(end))){
                result[start] = s.charAt(end);
                result[end] = s.charAt(start);
                start++;
                end--;
            }else if(charSet.contains(s.charAt(start))){
                result[end] = s.charAt(end);
                end--;
            }else if(charSet.contains(s.charAt(end))){
                result[start] = s.charAt(start);
                start++;
            }else {
                result[start] = s.charAt(start);
                result[end] = s.charAt(end);
                start++;
                end--;
            }
        }
        return new String(result);          //字符数组转化为字符串类型
    }
}
