package com.niuke.importance.mianjing;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,6,7,2,7,2,8,0,9,1};
        headSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void headSort(int[] nums){
        int index = (nums.length-1)/2;
        for(int i=index;i>=0;i--){
            buildHead(nums,nums.length,i);
        }
        for(int i=nums.length-1;i>=0;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            buildHead(nums,i,0);
        }
    }

    public static void buildHead(int[] nums,int size,int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int maxIndex = index;
        if(left < size && nums[left] > nums[maxIndex]){
            maxIndex = left;
        }
        if(right < size && nums[right] > nums[maxIndex]){
            maxIndex = right;
        }
        if(index != maxIndex){
            int temp = nums[index];
            nums[index] = nums[maxIndex];
            nums[maxIndex] = temp;
            buildHead(nums,size,maxIndex);
        }
    }
}
