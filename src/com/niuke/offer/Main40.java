package com.niuke.offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Main40 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public class Solution {
        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {          //位运算
            if(array.length < 2){
                return;
            }
            int nums = array[0];
            for(int i=1;i<array.length;i++){
                nums = nums ^ array[i];                         //WARN 相同元素异或结果抵消，剩下的为两个不同的元素的异或结果
            }
            nums = nums & -nums;                                //WARN 求两个不同的元素异或结果最后一位不为0的位，用于区别两个元素（nums & -nums）
            for (int num : array) {
                if((num & nums) != 0){                          //WARN 根据上面求得的不为0的位作为区分
                    num1[0] = num1[0] ^ num;
                }else {
                    num2[0] = num2[0] ^ num;
                }
            }
        }
    }
}
