package com.niuke.importance.mianjing;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,6,7,2,7,2,8,0,9,1};
        sort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] nums,int start,int end){
        if(start < end){
            int low = start;
            int high = end;
            int stard = nums[low];
            while(low < high){
                while(low < high && nums[high] >= stard){
                    high--;
                }
                nums[low] = nums[high];
                while(low < high && nums[low] <= stard){
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = stard;
            sort(nums,start,low);
            sort(nums,low+1,end);
        }
    }
}
