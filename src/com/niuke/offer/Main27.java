package com.niuke.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Main27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>(permutation(str));         //Set去重
        Collections.sort(list);                                             //去重后排序
        return list;
    }
    public HashSet<String> permutation(String str) {                        //递归
        HashSet<String> set = new HashSet<>();
        if(str == null){
            return null;
        }
        if(str.length() == 1){
            set.add(str);
            return set;
        }
        HashSet<String> temp = null;
        String splitString = null;
        for(int i=0;i<str.length();i++){
            if(i == 0){
                splitString = str.substring(1);
            }else if(i == str.length()-1){
                splitString = str.substring(0,str.length()-1);
            }else {
                splitString = str.substring(0,i) + str.substring(i+1);
            }
            temp = permutation(splitString);
            Iterator<String> iterator = temp.iterator();
            while(iterator.hasNext()){
                set.add(str.charAt(i)+iterator.next());
            }
        }
        return set;
    }
}
