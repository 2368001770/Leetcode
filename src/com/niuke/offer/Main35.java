package com.niuke.offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Main35 {               //TODO 归并
    int count = 0;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        mergeSort(array,0,array.length-1);
        return count;
    }

    private void mergeSort(int[] array,int begin,int end){
        if(begin < end){
            int mid = (begin + end) / 2;
            mergeSort(array,begin,mid);
            mergeSort(array,mid+1,end);
            merge(array,begin,mid,end);
        }
    }

    private void merge(int[] array,int begin,int mid,int end){
        int[] temp = new int[end-begin+1];            //在计算count的过程中用临时数组存储元素顺序
        int t = end - begin;
        int l = mid;
        int r = end;
        while(l>=begin && r>mid){
            if(array[l] > array[r]){
                count = count + r - mid;
                temp[t--] = array[l--];
                if(count >= 1000000007){
                    count = count % 1000000007;
                }
            }else {
                temp[t--] = array[r--];
            }
        }
        while(l >= begin){
            temp[t--] = array[l--];
        }
        while(r > mid){
            temp[t--] = array[r--];
        }
        for(int i=0;i<=end-begin;i++){
            array[begin+i] = temp[i];
        }
    }
}
