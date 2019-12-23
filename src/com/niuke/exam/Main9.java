package com.niuke.exam;

import java.util.*;

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        //TreeMap<Integer,Integer> treeMap = new TreeMap();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int peoples = 0;
        for(int i=0;i<count;i++){
            int people = scanner.nextInt();
            int time = scanner.nextInt();
            for(int k=0;k<people;k++){
                maxHeap.offer(time);
                minHeap.offer(time);
            }
            //treeMap.put(time,people);
            peoples += people;
        }
        int minTime = Integer.MIN_VALUE;
        for(int j=0;j<peoples/2;j++){
            int min = minHeap.poll();
            int max = maxHeap.poll();
            minTime = Math.max(min+max,minTime);
        }
        System.out.println(minTime);
//        for(int j=0;j<peoples/2;j++){
//            int minKey = treeMap.firstKey();
//            int maxKey = treeMap.lastKey();
//            minTime = Math.max(minKey+maxKey,minTime);
//            Integer min = treeMap.get(minKey);
//            Integer max = treeMap.get(maxKey);
//            if(min==1){
//                treeMap.remove(minKey);
//            }else {
//                treeMap.put(minKey,min-1);
//            }
//            if(max==1){
//                treeMap.remove(maxKey);
//            }else {
//                treeMap.put(maxKey,max-1);
//            }
//        }
//        System.out.println(minTime);
    }
}
