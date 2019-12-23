package com.niuke.leetcode.二分查找;

/**
 * 给定一个元素 n 代表有 [1, 2, ..., n] 版本，可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找
 * 到第一个错误的版本。
 */
public class LC278 {
    public int firstBadVersion(int n) {
        int l = 1,h = n;
        while(l < h){                   //因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
            int m = l + (h-l)/2;
            if(isBadVersion(m)){
                h = m;
            }else {
                l = m + 1;
            }
        }
        return l;
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
    boolean isBadVersion(int version){return true;};
}
