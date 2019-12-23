package com.niuke.offer;


import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Main34 {

    public int FirstNotRepeatingChar(String str) {                      // HashMap存储
        int result = -1;
        if(str == null || str.length() == 0){
            return result;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            Integer count = map.get(ch);
            if(count == null){
                map.put(ch,1);
            }else {
                map.put(ch,count+1);
            }
        }
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            Integer count = map.get(ch);
            if(count == 1){
                result = i;
                break;
            }
        }
        return result;
    }

    public int FirstNotRepeatingChar2(String str) {                     // 数组存储
        int result = -1;
        if(str == null && str.length() == 0){
            return result;
        }
        int[] chars = new int[256];
        for(int i=0;i<str.length();i++){
            chars[str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(chars[str.charAt(i)] == 1){
                result = i;
                break;
            }
        }
        return result;
    }

    public int FirstNotRepeatingChar3(String str) {                     // BitSet存储
        int result = -1;
        if(str == null || str.length() == 0){
            return result;
        }
        BitSet bitSet1 = new BitSet(256);
        BitSet bitSet2 = new BitSet(256);
        char[] chars = str.toCharArray();
        for(char ch:chars){
            if(!bitSet1.get(ch) && !bitSet2.get(ch)){               //WARN get(index)方法返回index为是否是1，布尔类型
               bitSet2.set(ch);
            }else if(!bitSet1.get(ch) && bitSet2.get(ch)){
                bitSet1.set(ch);
            }
        }
        for(int i=0;i<chars.length;i++){
            if(!bitSet1.get(chars[i]) && bitSet2.get(chars[i])){
                result = i;
                break;
            }
        }
        return result;
    }
}
