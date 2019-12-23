package com.niuke.leetcode.双指针;

import java.util.List;

/**
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output: "apple"
 *
 * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个
 * 相同长度的结果，返回字典序的最小字符串。
 */
public class LC524 {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for(String str : d){
            if(str.length()<longestWord.length() ||(str.length()==longestWord.length() && str.compareTo(longestWord)>0)){
                continue;
            }
            if(isValid(s,str)){
                longestWord = str;
            }
        }
        return longestWord;
    }

    private static boolean isValid(String s,String d){
        int dIndex = 0;
        int sIndex = 0;
        while(dIndex < d.length() && sIndex < s.length()){
            if(s.charAt(sIndex) == d.charAt(dIndex)){
                sIndex++;
                dIndex++;
            }else {
                sIndex++;
            }
        }
        return dIndex == d.length();
    }
}
