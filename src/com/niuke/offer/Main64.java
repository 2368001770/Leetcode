package com.niuke.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Main64 {
    /**
     * O(N)时间复杂度
     * 使用一个双端队列来存储下标,保证下标元素存储的顺序是他们下标对应的num数组元素的排序顺序
     * 储存下标是为了用于判断队列里的下标元素是否过期,直接存储num数组元素并不能保证
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length == 0 || size <1 || size > num.length){
            return list;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        //queue.offer(0);
        int index = 0;
        while(index < num.length){
            while(!queue.isEmpty() && num[index] > num[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offer(index);
            if(index - queue.peek() >= size){
                queue.poll();
            }
            if(index >= size-1){
                list.add(num[queue.peek()]);
            }
            index++;
        }
        return list;
    }
}
