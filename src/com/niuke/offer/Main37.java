package com.niuke.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Main37 {
    public int GetNumberOfK(int [] array , int k) {                     //找排序整数数组中找k出现的次数，可以找到k+0.5和k-0.5的下标，两者相减
        if(array == null || array.length == 0){
            return 0;
        }
        int left = getIndex(array,k-0.5);
        int right = getIndex(array,k+0.5);
        return right - left;
    }

    private int getIndex(int[] array,double k){
        int begin = 0;
        int end = array.length - 1;
        int mid;
        while(begin <= end){                        //WARN  begin <= end
            mid = (begin + end)/2;
            if(array[mid] > k){
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }
        return begin;                               //WARN  return begin
    }



    /**
     * 附二分查找算法代码
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) { // 注意
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
}
