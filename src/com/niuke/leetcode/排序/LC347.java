package com.niuke.leetcode.排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class LC347 {
    //用Map统计每个元素的出现频率，新建一个数组，遍历Map，把它的Value作为数组的下标，Key作为数组元素List中的一个值，从尾部遍历这个数组，找出TopK元素
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numToFreMap = new HashMap<>();
        for(int num : nums){
            numToFreMap.put(num,numToFreMap.getOrDefault(num,0)+1);         //Map的getOrDefault方法
        }
        List<Integer>[] freAndNums = new ArrayList[nums.length+1];
        for(Integer num : numToFreMap.keySet()){
            int fre = numToFreMap.get(num);
            if(freAndNums[fre] == null){
                freAndNums[fre] = new ArrayList<>();
            }
            freAndNums[fre].add(num);
        }
        List<Integer> topKFreNums = new ArrayList<>();
        for(int i=nums.length;i>0&&k>0;i--){
            if(freAndNums[i] == null){
                continue;
            }
            if(k>=freAndNums[i].size()){
                topKFreNums.addAll(freAndNums[i]);
                k -= freAndNums[i].size();
            }else {
                topKFreNums.addAll(freAndNums[i].subList(0,k));                        //List的subList方法以及addAll方法
                k = 0;
            }
        }
        return topKFreNums;
    }
}
