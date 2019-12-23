package com.niuke.exam;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] nums = new int[count];
        for(int i=0;i<count;i++){
            int numCount = scanner.nextInt();
            for(int j=0;j<numCount;j++){
                int num = scanner.nextInt();
                nums[i] += num;
            }
        }
        for(int k=0;k<count;k++){
            int result=nums[k]/2;
            if(nums[k]%2==1){
                System.out.println(result + " " + (result+1));
            }else {
                System.out.println(result + " " + result);
            }
        }
    }
}
