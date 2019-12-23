package com.niuke.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Main58 {

    /**
     * 递归
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return isSame(pRoot.left,pRoot.right);
    }

    private boolean isSame(TreeNode node1,TreeNode node2){              //递归判断两个子树是否对称
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 != null && node2 != null){
            if(node1.val == node2.val){
                return isSame(node1.left,node2.right) && isSame(node1.right,node2.left);
            }
        }
        return false;
    }

    /**
     * DFS
     * @param pRoot
     * @return
     */
    boolean isSymmetrical2(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot.left);                         //WARN 保证对称的节点进栈，就算为null也要进
        stack.push(pRoot.right);
        while(!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1 == null && node2 == null){
                continue;                               //WARN 不能写return true
            }
            if(node1 == null || node2 == null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }

    /**
     * BFS
     * @param pRoot
     * @return
     */
    boolean isSymmetrical3(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}