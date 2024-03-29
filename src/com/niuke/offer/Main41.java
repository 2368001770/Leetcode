package com.niuke.offer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Main41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(sum < 3){
            return lists;
        }
        int begin = 1,end = 2,sums = 3;
        while(end < sum){
            if(sums == sum){                                    //WARN 注意相等后begin和end的位置都向后移动一位，他们之间的和sums也相应改变
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=begin;i<=end;i++){
                    list.add(i);
                }
                lists.add(list);
                sums = sums - begin;
                begin++;
                end++;
                sums = sums + end;
            }else if(sums > sum){
                sums = sums - begin;
                begin++;
            }else {
                end++;
                sums = sums + end;
            }
        }
        return lists;
    }
}
