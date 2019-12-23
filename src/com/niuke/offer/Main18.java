package com.niuke.offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Main18 {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
    }
}
