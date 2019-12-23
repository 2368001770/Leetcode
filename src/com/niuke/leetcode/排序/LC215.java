package com.niuke.leetcode.排序;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Kth Element
 * 找到第 k 大的元素。
 */
public class LC215 {
    public int findKthLargest1(int[] nums, int k) {             //排序__时间复杂度 O(NlogN)，空间复杂度 O(1)
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest2(int[] nums, int k) {             //堆排序__时间复杂度 O(NlogK)，空间复杂度 O(K)
        PriorityQueue<Integer> minHead = new PriorityQueue<>(k);
        for(int num : nums){
            minHead.offer(num);
            if(minHead.size() > k){
                minHead.poll();
            }
        }
        return minHead.peek();
    }

    public int findKthLargest3(int[] nums, int k) {             //快速排序__时间复杂度 O(N)，空间复杂度 O(1)
        k = nums.length-k;
        int i = 0,j = nums.length-1;
        while(i<j){
            int partition = partition(nums,i,j);
            if(partition == k){
                return nums[k];
            }else if(partition > k){
                j = partition-1;
            }else {
                i = partition+1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums,int i,int j){
        int baseNum = nums[i];
        while(i<j){
            while(nums[j]>=baseNum && i<j){
                j--;
            }
            nums[i] = nums[j];
            while(nums[i]<=baseNum && i<j){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = baseNum;
        return i;
    }
}
