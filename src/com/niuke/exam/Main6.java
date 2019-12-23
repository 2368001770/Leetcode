package com.niuke.exam;

import java.util.Scanner;

/**
 * 美团编程题
 * 匹配值最大
 * TODO 18%
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        double[][] nums = new double[length][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                nums[i][j]=scanner.nextDouble();
            }
        }
        double sum = 0;
        int[] index = new int[length];
        for(int m=0;m<length;m++){
            double max = 0;
            int x=0,y=0;
            for(int n=0;n<length;n++){
                for(int h=0;h<length;h++){
                    if(nums[n][h]>max){
                        max=nums[n][h];
                        x=n;
                        y=h;
                    }
                }
                index[x]=y;
            }
            for(int g=0;g<length;g++){
                nums[x][g]=0;
                nums[g][y]=0;
            }
            sum = sum + max;
        }
        System.out.println(sum);
        for(int z=0;z<length;z++){
            System.out.println((z+1) + " " + (index[z]+1));
        }
    }
}
