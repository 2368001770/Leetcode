package com.niuke.exam;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int luns = scanner.nextInt();
        int[] nums = new int[numCount];
        for(int i=0;i<numCount;i++){
            nums[i] = scanner.nextInt();
        }
        for(int j=0;j<luns;j++){
            int minNum = Integer.MAX_VALUE;
            for(int k=0;k<numCount;k++){
                if(nums[k]!=0&&nums[k]<minNum){
                    minNum = nums[k];
                }
            }
            if(minNum==Integer.MAX_VALUE){
                System.out.println(0);
            }else {
                System.out.println(minNum);
                for(int z=0;z<numCount;z++){
                    if(nums[z]>=minNum){
                        nums[z] -= minNum;
                    }
                }
            }
        }
    }
}
