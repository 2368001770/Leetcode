package com.niuke.leetcode.双指针;

/**
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 *
 * 把归并结果存到第一个数组上。
 */
public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        int mergeIndex = nums1.length - 1;
        while(m < mergeIndex){                      //注意临界条件的判断（避免空指针异常）
            if(m < 0){
                nums1[mergeIndex--] = nums2[n--];
            }else if(n < 0){
                nums1[mergeIndex--] = nums1[m--];
            }else if(nums1[m] <= nums2[n]){
                nums1[mergeIndex--] = nums2[n--];
            }else {
                nums1[mergeIndex--] = nums1[m--];
            }
        }
    }
}
