package com.niuke.offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Main39 {

    /**
     * 设置全局函数，每个节点左右节点高度差不大于1即为平衡的，
     * 在求根节点高度时正好可以直到每个节点的左右节点高度，
     * 也就是可以在求高度的时候顺带去判断以当前节点为根节点的子树高度差是否超过1，
     * 若超过1则令全局变量isBalance设置为false，使递归函数结束
     */
    boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return isBalanced;
        }
        high(root);
        return isBalanced;
    }

    private int high(TreeNode node){
        if(node == null || !isBalanced){
            return 0;
        }
        int left = high(node.left);
        int right = high(node.right);
        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }
        return Math.max(left,right) + 1;
    }


    /**
     * 错误代码：ac:28.57%
     */
    /*public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        if (Math.abs(higt(root.left) - higt(root.right)) > 1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int higt(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        if(treeNode.left == null || treeNode.right == null){
            return 1;
        }
        return Math.max(higt(treeNode.left),higt(treeNode.right)) + 1;
    }*/
}
