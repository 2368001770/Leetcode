package com.niuke.exam;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        long result=1;
        if(n<=10){
            for(int i=1;i<=n;i++){
                result *=i;
            }
        }else {
            for(int i=1;i<9;i++){
               result *= i;
            }
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(result));
            int j=stringBuilder.length()-1;
            while(stringBuilder.charAt(j)=='0'){
                j--;
            }
            int num = stringBuilder.charAt(j);
            long count = result/10;
            long index = result%10;
            int re = 1;
            while(count-->0){
                re *= num;
            }
            for(int y=1;y<=index;y++){
                re *= index;
            }
            result = re;
        }

        StringBuilder stringBuilder = new StringBuilder(String.valueOf(result));
        int j=stringBuilder.length()-1;
        while(stringBuilder.charAt(j)=='0'){
            j--;
        }

        System.out.println(stringBuilder.charAt(j));
    }
}
