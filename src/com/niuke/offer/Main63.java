package com.niuke.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Main63 {                       //用一个大顶堆和一个小顶堆维护

    PriorityQueue<Integer> minHead = new PriorityQueue<>(); //WANR 默认小顶堆
    PriorityQueue<Integer> maxHead = new PriorityQueue<>(new Comparator<Integer>() {  // 大顶堆
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;                          // 计数器count标记当前数字应当插入哪个堆（不是直接插入，而是进过另一个堆过滤后插入）
    public void Insert(Integer num) {
        if(count%2 == 0){
            maxHead.offer(num);
            int max = maxHead.poll();
            minHead.offer(max);
        }else {
            minHead.offer(num);
            int min = minHead.poll();
            maxHead.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        if(count>0 && count%2 == 0){
            return (minHead.peek()+maxHead.peek())/2.0;     //ERROR 注意不能用pop()取出
        }else {
            return Double.valueOf(minHead.peek());
        }
    }
}
