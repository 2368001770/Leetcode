package com.niuke.leetcode.贪心思想;

/**
 * 判断是否为子序列
 * s = "abc", t = "ahbgdc"
 * Return true.
 */
public class LC392 {
    //按顺序遍历从s中的每一个字符，并从t中往后找到该字符
    public boolean isSubsequence(String s, String t) {
        int sIndex=0,tIndex = 0;
        while(sIndex<s.length()&&tIndex<t.length()){
            while(tIndex<t.length()&&t.charAt(tIndex)!=s.charAt(sIndex)){
                tIndex++;
            }
            if(tIndex<t.length()&&t.charAt(tIndex)==s.charAt(sIndex)){      //注意t中可能找到sIndex位置的字符也可能没找到（s='a',t='b'）
                sIndex++;
                tIndex++;
            }
        }
        return sIndex==s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c,index+1);               //String的indexOf(char c,int fromIndex)方法，在该字符串的第fromIndex位置开始查找字符c的位置
            if(index==-1){
                return false;
            }
        }
        return true;
    }
}
