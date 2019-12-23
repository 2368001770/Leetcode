package com.niuke.leetcode.贪心思想;

/**
 * 判断一个数组能不能只修改一个数就成为非递减数组。
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 */
public class LC665 {
    //[5,6,4]
    //num[i]<num[i-1]时需要修改：若num[i-2]>num[i],则修改num[i]=num[i-1],否则修改num[i-1]=num[i]
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i=1; i<nums.length && cnt<2; i++){
            if(nums[i]>=nums[i-1]){
                continue;
            }
            cnt++;
            if(i>1&&nums[i]<nums[i-2]){
                nums[i] = nums[i-1];
            }else {
                nums[i-1] = nums[i];
            }
        }
        return cnt<=1;
    }
}
