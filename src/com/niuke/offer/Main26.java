package com.niuke.offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Main26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        TreeNode head = pRootOfTree;
        if(pRootOfTree.left != null){
            head = Convert(pRootOfTree.left);
        }
        TreeNode lastLeft = head;
        while(lastLeft != pRootOfTree && lastLeft.right != null){           //WARN 注意lastLeft != pRootOfTree条件
            lastLeft = lastLeft.right;
        }
        if(head != pRootOfTree){
            lastLeft.right = pRootOfTree;
            pRootOfTree.left = lastLeft;
        }
        TreeNode firstRight = Convert(pRootOfTree.right);
        if(firstRight != null){
            pRootOfTree.right = firstRight;
            firstRight.left = pRootOfTree;
        }
        return head;
    }
}
