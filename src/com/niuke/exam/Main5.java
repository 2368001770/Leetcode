package com.niuke.exam;

import java.util.Scanner;

/**
 * 美团编程题
 * 布尔运算
 * TODO 70%
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String[] str = s.split(" ");
            if(str.length % 2 ==0){
                System.out.println("error");
                return;
            }
            if(str.length==1){
                if(str[0].equals("true")||str[0].equals("false")){
                    System.out.println("error");
                    return;
                }
            }
            for(int k=0;k<str.length;k++){
                if(k%2==0){
                    if(str[k].equals("and")||str[k].equals("or")){
                        System.out.println("error");
                        return;
                    }
                }else {
                    if(str[k].equals("true")||str[k].equals("false")){
                        System.out.println("error");
                        return;
                    }
                }
            }
            String[] strings = s.split("or");
            boolean a = false;
            for(int i=0;i<strings.length;i++){
                boolean b = true;
                String s1 = strings[i].trim();
                String[] strings1 = s1.split("and");
                for(int j=0;j<strings1.length;j++){
                    String s2 = strings1[j].trim();
                    if(s2.equals("true")){
                        b = b && true;
                    }else if(s2.equals("false")){
                        b = b && false;
                    }else {
                        System.out.println("error");
                        return;
                    }
                }
                a = a || b;
            }
            if(a == true){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }
}
