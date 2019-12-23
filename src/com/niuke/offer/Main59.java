package com.niuke.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class Main59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {        //用两个栈分别存放奇数层和偶数层节点
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot == null){
            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack1.add(pRoot);
        boolean order = true;                                       //order标记顺序
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(order){
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if(node.left != null){                         //奇数层先把左节点放入另一个栈
                        stack2.push(node.left);
                    }
                    if(node.right != null){
                        stack2.push(node.right);
                    }
                }
                order = false;
                lists.add(list);
                list = new ArrayList<>();
            }else {
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if(node.right != null){                         //偶数层先把右节点放入另一个栈
                        stack1.push(node.right);
                    }
                    if(node.left != null){
                        stack1.push(node.left);
                    }
                }
                order = true;
                lists.add(list);
                list = new ArrayList<>();
            }
        }
        return lists;
    }
}
