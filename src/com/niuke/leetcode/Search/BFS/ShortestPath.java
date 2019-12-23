package com.niuke.leetcode.Search.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算在网格中从原点到特定点的最短路径长度
 * [[1,1,0,1],
 * [1,0,1,0],
 * [1,1,1,1],
 * [1,0,1,1]]
 * 1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
public class ShortestPath {
    public static int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1,0},{0,-1},{-1,0},{0,1}};
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while(size-- > 0){
                Pair<Integer,Integer> curr = queue.poll();
                int currLine = curr.getLine(), currColumn = curr.getColumn();
                grids[currLine][currColumn] = 0;                //标记，把已遍历的位置设置为0，防止重复遍历，虽然不会影响结果，但是可以避免多余的遍历操作
                for (int[] d : direction){
                    int newLine = currLine + d[0], newColumn = currColumn + d[1];
                    if(newLine < 0 || newLine >= m || newColumn < 0 || newColumn >= n){
                        continue;
                    }
                    if(newLine == tr && newColumn == tc){
                        return pathLength;
                    }
                    queue.add(new Pair<>(newLine,newColumn));
                }
            }
        }
        return -1;
    }

    static class Pair<T,S>{
        T line;
        S column;

        public Pair(T line, S column){
            this.line = line;
            this.column = column;
        }

        public T getLine() {
            return line;
        }

        public void setLine(T line) {
            this.line = line;
        }

        public S getColumn() {
            return column;
        }

        public void setColumn(S column) {
            this.column = column;
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1,1,0,1},{1,0,1,0},{1,1,1,1},{1,0,1,1}};
        System.out.println(minPathLength(array,3,1));
    }
}
