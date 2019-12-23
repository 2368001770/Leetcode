package com.niuke.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Main13 {
    public void reOrderArray(int[] nums) {          //若用两个数组分别存放奇偶数，时间复杂度和空间复杂度都比较大，可以先计算奇数的个数，新建一个数组两个指针分别指向奇数和偶数的位置
        int oddCnt = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 == 1){
                oddCnt++;
            }
        }
        int[] newArray = nums.clone();
        int j = 0;
        for(int i = 0;i<newArray.length;i++){
            if(newArray[i]%2 == 0){
                nums[oddCnt++] = newArray[i];
            }else {
                nums[j++] = newArray[i];
            }
        }
    }
    public void reOrderArray2(int[] nums) {                 //时间换空间
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]%2==0 && nums[j+1]%2==1){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
