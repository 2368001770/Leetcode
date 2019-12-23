package com.niuke.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Main23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        int lastNum = sequence[sequence.length - 1];
        int index = 0;
        while(index<sequence.length && sequence[index] < lastNum){
            index++;
        }
        for(int i=index;i<sequence.length-1;i++){
            if(sequence[i]<lastNum){
                return false;
            }
        }
        boolean left = true,right = true;
        if(index != 0){
            int[] arr1 = new int[index];
            for(int i=0;i<index;i++){
                arr1[i] = sequence[i];
            }
            left = VerifySquenceOfBST(arr1);
        }
        if(index != sequence.length-1){
            int[] arr2 = new int[sequence.length-1-index];
            for(int i=0;i<sequence.length-1-index;i++){
                arr2[i] = sequence[i+index];
            }
            right = VerifySquenceOfBST(arr2);
        }
        return left&&right;
    }
}
