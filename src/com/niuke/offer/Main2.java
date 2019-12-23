package com.niuke.offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Main2 {
    public String replaceSpace(StringBuffer str) {
        int oldLength = str.length();
        for(int i=0;i<oldLength;i++){
            if(str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        int oldIndex = oldLength - 1;
        int newIndex = str.length() - 1;
        while(oldLength >= 0 && oldIndex < newIndex){
            char c = str.charAt(oldIndex--);
            if(c == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else {
                str.setCharAt(newIndex--,c);        //StringBuffer对象的setCharAt方法，String对象没有
            }
        }
        return str.toString();
    }

    public String replaceSpace2(String str){
        String[] strings = str.split(" ");     //String对象的split方法，StringBuffer对象没有
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<strings.length;i++){
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }
}
