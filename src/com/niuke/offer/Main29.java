package com.niuke.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Main29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {           //冒泡k次
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k<=0 || k>input.length){
            return list;
        }
        for(int i=0;i<k;i++){
            for(int j=input.length-1;j>i;j--){
                if(input[j]<input[j-1]){
                    int temp = input[j];
                    input[j]= input[j-1];
                    input[j-1] = temp;
                }
            }
            list.add(input[i]);
        }
        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {           //大顶堆
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k<=0 || k>input.length){
            return list;
        }
        PriorityQueue<Integer> maxHead = new PriorityQueue<>(k, new Comparator<Integer>() {        // WARN 默认为小顶堆，需声明一个比较器使其为大顶堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i=0;i<input.length;i++){
            if(maxHead.size() == k) {
                Integer temp = maxHead.peek();
                if (input[i] < temp) {
                    maxHead.poll();
                    temp = null;
                    maxHead.offer(input[i]);
                }
            }else {
                maxHead.offer(input[i]);
            }
        }

        /*for(int j=0;j<maxHead.size();j++){                        // ERROR 此处遍历错误，每次便利后j自增maxHead.size自减，会跨过一个元素，可以先用一个临时变量存储size
            list.add(maxHead.poll());
        }*/

        while(maxHead.size() != 0){
            list.add(maxHead.poll());
        }

        /*for (Integer num : maxHead){                              // WARN 或者直接遍历堆中的元素
            list.add(num);
        }*/

        return list;
    }

    /**
     * 这种快排递归中没有重用一个数组，效率较低,方法较长
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {          //快速排序（1）
        ArrayList<Integer> list = new ArrayList<>();
        if(input==null || k<=0 || k>input.length){
            return list;
        }
        int start=0,end=input.length-1;
        int temp = input[start];
        while(start<end){
            while (start < end && input[end] > temp){
                end--;
            }
            input[start] = input[end];
            while(start < end && input[start] <= temp){
                start++;
            }
            input[end] = input[start];
        }
        input[start] = temp;
        if(start == k){
            for(int i=0;i<k;i++){
                list.add(input[i]);
            }
            return list;
        }else if(start < k){
            for(int j=0;j<=start;j++){
                list.add(input[j]);                                       // WARN 需把左边的元素也添加到list中，否则左边的元素会丢失
            }
            int[] right = new int[input.length-start-1];
            for(int i=0;i<right.length;i++){
                right[i] = input[start+i+1];
            }
            ArrayList<Integer> listLeft = GetLeastNumbers_Solution3(right,k-start-1);
            list.addAll(listLeft);
            return list;
        }else {
            int[] left = new int[start];
            for (int i=0;i<left.length;i++){
                left[i] = input[i];
            }
            return GetLeastNumbers_Solution3(left,k);
        }
    }

    /**
     * 这种快速排序对数组进行重用，内存效率高，层次明显
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution4(int [] input, int k) {                  //快速排序（2）
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k == 0 || k > input.length){
            return list;
        }
        findKMin(input,0,input.length-1,k);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    //将input数组中下标为low-high的元素进行快速排序，使数组中前k个元素均小于input[k]（快排partition刚好为k）
    private void findKMin(int[] input,int low,int high,int k){
        int partition = partition(input,low,high);
        if(partition == k-1){                                           // WARN 注意不是partition==k，因为若k为数组的长度，会出现错误
            return;
        }else if(partition < k-1){
            findKMin(input,partition+1,high,k);
        }else {
            findKMin(input,low,partition-1,k);
        }
    }

    //快速排序
    private int partition(int[] input,int low,int high){
        int temp = input[low];
        while(low < high){
            while(low < high && input[high] > temp){
                high--;
            }
            input[low] = input[high];
            while(low < high && input[low] <= temp){
                low++;
            }
            input[high] = input[low];
        }
        input[low] = temp;
        return low;
    }
}
