package com.niuke.exam;

import java.util.Scanner;

/**
 * 有赞编程题
 * 最长回文子串
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getResultString(str,0,str.length()-1));
    }

    private static String getResultString(String s,int begin,int end){
        if(begin>end){
            return "";
        }
        if(getResiltString(s,begin,end)){
            return s.substring(begin,end+1);
        }else {
            String str1 = getResultString(s,begin,end-1);
            String str2 = getResultString(s,begin+1,end);
            return str1.length()>str2.length()?str1:str2;
        }
    }

    private static boolean getResiltString(String s,int begin,int end){
        while(begin<end&&s.charAt(begin)==s.charAt(end)){
            begin++;
            end--;
        }
        return begin>=end;
    }
}
