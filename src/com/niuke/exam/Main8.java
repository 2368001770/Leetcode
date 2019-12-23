package com.niuke.exam;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] strLengths = new int[count];
        String[] strs = new String[count];
        boolean[] booleans = new boolean[count];
        for(int i=0;i<count;i++){
            strLengths[i] = scanner.nextInt();
            strs[i] = scanner.next();
        }
        for(int j=0;j<count;j++){
            if(strLengths[j]<11){
                booleans[j]=false;
            }else {
                int k;
                for(k=0;k<strLengths[j];k++){
                    if(strs[j].charAt(k)=='8'){
                        if(strLengths[j]-k>=11){
                            booleans[j] = true;
                        }else {
                            booleans[j] = false;
                        }
                        break;
                    }
                }
            }
        }
        for(int x=0;x<count;x++){
            if(booleans[x]==true){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
