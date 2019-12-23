package com.niuke.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Main28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        int count=0,index=0,result=array[0];
        while(index < array.length){                //WARN 若此处写index++，则后面的index都为加一后的结果，出现错误，所以在末尾index++
            if(count == 0){
                result = array[index];
                count++;
            }else if(array[index] == result){
                count++;
            }else {
                count--;
            }
            index++;
        }
        count = 0;
        for(int i=0;i<array.length;i++){           //result可能时出现大于一半的结果，但是不确定，需再次判断
            if(array[i] == result){
                count++;
            }
        }
        if(count > array.length/2){
            return result;
        }
        return 0;
    }
}
