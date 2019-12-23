package com.niuke.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++){
            nums[i] = scanner.nextInt();
        }
//        for(int j=0;j<nums.length;j++){
//            for(int k=1;k<nums.length-j;k++){
//                if(nums[k]<nums[k-1]){
//                    int temp = nums[k];
//                    nums[k] = nums[k-1];
//                    nums[k-1] = temp;
//                }
//            }
//        }
        Arrays.sort(nums);
        int firstIndex = 0;
        int lastIndex = M*2-1;
        long sum = 0;
        while(lastIndex>firstIndex){
            sum = sum + nums[firstIndex]*nums[lastIndex];
            lastIndex--;
            firstIndex++;
        }
        System.out.println(sum);
    }

}
