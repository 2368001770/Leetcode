package com.niuke.exam;

import java.util.Scanner;

/**
 * 搜狗编程题
 * IP地址匹配
 * 注意输出格式（一行输出所有 -> print与 println）恨啊！！！
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[] ns = new String[N];
        String[] ms = new String[M];
        for(int i=0;i<N;i++){
            ns[i] = scanner.next();
        }
        for(int j=0;j<M;j++){
            ms[j] = scanner.next();
        }
        prints(ns,ms);
    }

    public static void prints(String[] ns,String[] ms){
        for(int i=0;i<ms.length;i++){
            int n=0;
            for(int j=0;j<ns.length;j++){
                if(print(ns[j],ms[i])){
                    n++;
                }
            }
            if(n>0){
                System.out.print(1+" ");
            }else {
                System.out.print(0+" ");
            }
        }
    }

    public static boolean print(String nStr,String mStr){
        String[] strings = nStr.split("\\.");
        String[] mStrs = mStr.split("\\.");
        if(strings.length == 1) {
            return true;
        }
        if(strings.length == 4 && !strings[0].equals("*")&&!strings[3].equals("*")){
            for(int i=0;i<4;i++){
                if(!strings[i].equals(mStrs[i])){
                    return false;
                }
            }
            return true;
        }
        if(strings[0].equals("*")){
            for(int k = 3,j=strings.length-1;j>0;j--,k--){
                if(!strings[j].equals(mStrs[k])){
                    return false;
                }
            }
            return true;
        }else if(strings[strings.length-1].equals("*")){
            for(int m=0;m<strings.length-1;m++){
                if(!strings[m].equals(mStrs[m])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
