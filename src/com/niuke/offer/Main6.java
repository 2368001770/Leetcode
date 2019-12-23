package com.niuke.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Main6 {
    public int minNumberInRotateArray(int[] nums) {         //把中间位与左边位比较，若比左边的大，则新的左边位为mid+1，出现的问题：数组原来就是顺序的？
        if(nums.length == 0){
            return 0;
        }
        int left = 0,right = nums.length-1;
        if(nums[left]<nums[right]){
            return nums[left];
        }
        while(left < right){                        //TODO 36%
            int mid = (left + right)/2;
            if(nums[mid] > nums[left]){
                left = mid + 1;
            }else if(nums[mid] < nums[left]){
                right = mid;
            } else
                return Math.min(nums[left],nums[right]);
        }
        return nums[left];
    }

    public int minNumberInRotateArray2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            } else
                return Math.min(nums[left],nums[right]);
        }
        return nums[left];
    }

    public int minNumberInRotateArray3(int[] nums) {        //中间位和最右边位比较
        if(nums.length == 0){
            return 0;
        }
        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else
                right = mid;
        }
        return nums[left];
    }

    public int minNumberInRotateArray4(int[] nums) {        //中间位和最右边位比较, 确保重复元素{1,1,1,0,1}正确性
        if(nums.length == 0){
            return 0;
        }
        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == nums[left] && nums[mid] == nums[right]){
                for(int i=left;i<right;i++){
                    if(nums[i] < nums[i+1]){
                        return nums[i];
                    }
                }
                return nums[right];
            }
            else if(nums[mid] > nums[right]){
                left = mid + 1;
            }else
                right = mid;
        }
        return nums[left];
    }
}
