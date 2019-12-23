package com.niuke.offer;

/**
 * 给出一副扑克牌+两张大小王=56张牌。抽出5张牌，判断是否扑克牌顺子：4个大小王看做数字0，大小王可以看成任意数字。
 */
public class Main45 {
    public boolean isContinuous(int [] numbers) {           //除了数字0，其他数字不能重复，且最大值和最小值差不能超过4
        if(numbers == null || numbers.length != 5){
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(num == 0){
                continue;
            }
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
            if(max-min > 4){
                return false;
            }
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[j] == 0){
                    continue;
                }
                if(num == numbers[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
