package com.niuke.offer;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如,（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class Main62 {                           //WARN 其实就是中序遍历到第k个节点

    TreeNode node = null;
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {                   //递归中序遍历
        if(pRoot == null || k < 1){
            return node;
        }
        index = k;
        midSort(pRoot);
        return node;
    }

    private void midSort(TreeNode root){
        if(node != null || root == null){
            return;
        }
       /* if(index == 0){                   // ERROR 不应该在此处判断index的值
            node = root;
            return;
        }*/
        midSort(root.left);
        index--;
        if(index == 0){                     // WARN
            node = root;                    // WARN 标记找到的节点,并使其不再递归进行下去(破坏递归开始判断条件)
            return;
        }
        midSort(root.right);
    }

    TreeNode KthNode2(TreeNode pRoot, int k) {               //非递归中序遍历 (栈)
        if(pRoot == null || k < 1){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(pRoot != null || !stack.isEmpty()){
            while(pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            TreeNode node = stack.pop();
            k--;
            if(k == 0){
                return node;
            }
            pRoot = node.right;
        }
        return null;
    }
}
