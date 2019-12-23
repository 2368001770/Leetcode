package com.niuke.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Main60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {               //BFS,用一个计数器把每层的个数记录下来
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot == null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(pRoot);
        int count = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            count--;
            if(count == 0){
                lists.add(list);
                count = queue.size();
                list = new ArrayList<>();
            }
        }
        return lists;
    }
}
