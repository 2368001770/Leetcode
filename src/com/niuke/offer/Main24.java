package com.niuke.offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Main24 {

    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return lists;
        }
        find(root,target,lists,list);
        return lists;
    }

    private void find(TreeNode treeNode,int target,ArrayList<ArrayList<Integer>> lists,ArrayList<Integer> list){
        if(treeNode == null || target < 0){
            list.remove(list.size()-1);
            return;
        }
        list.add(treeNode.val);                                             //确保已经添加了才回退
        target = target - treeNode.val;
        if(treeNode.left == null && treeNode.right == null && target == 0){
            lists.add(list);
        }
        if(treeNode.left != null){
            find(treeNode.left,target,lists,list);
        }
        if(treeNode.right != null){
            find(treeNode.right,target,lists,list);
        }
        list.remove(list.size()-1);
    }


    /**
     * 以下为错误代码
     * 原因：如果没有添加元素也会回退了
     * @param treeNode
     * @param target
     * @param lists
     * @param list
     */
    private void find2(TreeNode treeNode,int target,ArrayList<ArrayList<Integer>> lists,ArrayList<Integer> list){       //错误代码
        if(treeNode == null || target < 0){
            list.remove(list.size()-1);
            return;
        }
        if(treeNode.left == null && treeNode.right == null && target == treeNode.val){
            list.add(target);
            lists.add(list);
        }
        if(treeNode.left != null){
            list.add(treeNode.val);
            find(treeNode.left,target - treeNode.val,lists,list);
        }
        if(treeNode.right != null){
            list.add(treeNode.val);
            find(treeNode.right,target - treeNode.val,lists,list);
        }
        list.remove(list.size()-1);                           //若以上条件都没满足，元素没有添加也会回退一个，造成错误
    }
}
