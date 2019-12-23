package com.niuke.offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Main4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length != in.length || pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        int i;
        for(i=0;i<in.length;i++){
            if(in[i] == pre[0]){
                break;
            }
        }
        if(i > 0){
            int[] pr = new int[i];
            int[] inf = new int[i];
            for(int j=0;j<i;j++){
                pr[j] = pre[j+1];
                inf[j] = in[j];
            }
            node.left = reConstructBinaryTree(pr,inf);
        }else {
            node.left = null;
        }

        if(i < pre.length - 1){
            int[] pr = new int[pre.length-1-i];
            int[] inf = new int[pre.length-1-i];
            for(int j=i+1;j<pre.length;j++){
                pr[j-i-1] = pre[j];
                inf[j-i-1] = in[j];
            }
            node.right = reConstructBinaryTree(pr,inf);
        }else {
            node.right = null;
        }
        return  node;
    }

    public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
        return reConstructBinaryTree2(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode reConstructBinaryTree2(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode headNode = new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++){
            if(in[i] == pre[startPre]){
                headNode.left = reConstructBinaryTree2(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                headNode.right = reConstructBinaryTree2(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return headNode;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}