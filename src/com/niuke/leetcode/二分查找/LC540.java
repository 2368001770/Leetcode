package com.niuke.leetcode.二分查找;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
 * Output: 2
 */
public class LC540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0,h = nums.length-1;
        while(l<h){                         //因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
            int m = l + (h-l)/2;
            if(m%2==1){                     // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
                m--;
            }
            if(nums[m] == nums[m+1]){
                l = m + 2;
            }else {
                h = m;
            }
        }
        return nums[l];
    }
}
